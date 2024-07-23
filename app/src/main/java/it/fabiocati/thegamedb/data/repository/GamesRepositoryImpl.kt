package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.CompanyDataModel
import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.ImageDataModel
import it.fabiocati.thegamedb.data.model.InvolvedCompanyDataModel
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class GamesRepositoryImpl(
    private val gameDbService: TheGameDbService
) : GamesRepository {

    override suspend fun getGames(limit: Int, offset: Int, gameIds: List<Int>): List<Game> = coroutineScope {
        val gamesDataModels = gameDbService.getGames(limit = limit, offset = offset, gameIds = gameIds)

        val coverIds = gamesDataModels.mapNotNull { it.cover }
        val screenshotIds = gamesDataModels.flatMap { it.screenshots }
        val artworksIds = gamesDataModels.flatMap { it.artworks }
        val companiesIds = gamesDataModels.flatMap { it.involvedCompanies }

        val coverDataModels = async { gameDbService.getCovers(*coverIds.toIntArray()) }
        val screenshotsDataModels = async { gameDbService.getScreenshots(*screenshotIds.toIntArray()) }
        val artworksDataModels = async { gameDbService.getArtworks(*artworksIds.toIntArray()) }

        val involvedCompaniesDataModels = async { gameDbService.getInvolvedCompanies(*companiesIds.toIntArray()) }
        val companiesDataModels = async {
            val companiesId = involvedCompaniesDataModels.await().map { it.companyId }
            gameDbService.getCompanies(*companiesId.toIntArray())
        }

        awaitAll(coverDataModels, screenshotsDataModels, artworksDataModels, companiesDataModels)

        return@coroutineScope gamesDataModels.toGameList(
            coverDataModels = coverDataModels.await(),
            screenshotsDataModels = screenshotsDataModels.await(),
            artworksDataModels = artworksDataModels.await(),
            involvedCompaniesDataModels = involvedCompaniesDataModels.await(),
            companiesDataModels = companiesDataModels.await()
        )
    }
}

private fun List<GameDataModel>.toGameList(
    coverDataModels: List<ImageDataModel>,
    screenshotsDataModels: List<ImageDataModel>,
    artworksDataModels: List<ImageDataModel>,
    involvedCompaniesDataModels: List<InvolvedCompanyDataModel>,
    companiesDataModels: List<CompanyDataModel>
): List<Game> =
    this.map { gameDataModel ->
        val cover = coverDataModels.firstOrNull { cover -> cover.id == gameDataModel.cover }
        val coverUrl = cover?.url?.getImageUrl()

        val screenshots = screenshotsDataModels.filter { gameDataModel.screenshots.contains(it.id) }.map { it.url.getImageUrl() }
        val artworks = artworksDataModels.filter { gameDataModel.artworks.contains(it.id) }.map { it.url.getImageUrl() }
        val involvedCompaniesIds = involvedCompaniesDataModels.filter { gameDataModel.involvedCompanies.contains(it.id) }.map { it.companyId }
        val companies = companiesDataModels.filter { involvedCompaniesIds.contains(it.id) }

        Game(
            id = gameDataModel.id.toString(),
            name = gameDataModel.name,
            coverUrl = coverUrl,
            screenshotUrls = screenshots,
            artworkUrls = artworks,
            developmentCompany = companies.firstOrNull()?.name
        )
    }


private fun String.getImageUrl(): String = this.replace("//", "https://").replace("t_thumb", "t_1080p")
package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.ImageDataModel
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


        val coverDataModelsAsync = async { gameDbService.getCovers(*coverIds.toIntArray()) }
        val screenshotsDataModelsAsync = async { gameDbService.getScreenshots(*screenshotIds.toIntArray()) }
        val artworksDataModelsAsync = async { gameDbService.getArtworks(*artworksIds.toIntArray()) }


        val (coverDataModels, screenshotsDataModels, artworksDataModels) = awaitAll(coverDataModelsAsync, screenshotsDataModelsAsync, artworksDataModelsAsync)

        return@coroutineScope gamesDataModels.toGameList(
            coverDataModels = coverDataModels,
            screenshotsDataModels = screenshotsDataModels,
            artworksDataModels = artworksDataModels
        )
    }
}

private fun List<GameDataModel>.toGameList(
    coverDataModels: List<ImageDataModel>,
    screenshotsDataModels: List<ImageDataModel>,
    artworksDataModels: List<ImageDataModel>
): List<Game> =
    this.map { gameDataModel ->
        val cover = coverDataModels.firstOrNull { cover -> cover.id == gameDataModel.cover }
        val coverUrl = cover?.url?.getImageUrl()

        val screenshots = screenshotsDataModels.filter { gameDataModel.screenshots.contains(it.id) }.map { it.url.getImageUrl() }
        val artworks = artworksDataModels.filter { gameDataModel.artworks.contains(it.id) }.map { it.url.getImageUrl() }

        Game(
            id = gameDataModel.id.toString(),
            name = gameDataModel.name,
            coverUrl = coverUrl,
            screenshotUrls = screenshots,
            artworkUrls = artworks,
        )
    }


private fun String.getImageUrl(): String = this.replace("//", "https://").replace("t_thumb", "t_1080p")
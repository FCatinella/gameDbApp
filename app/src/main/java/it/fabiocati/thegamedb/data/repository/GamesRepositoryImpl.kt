package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.datetime.LocalDate

class GamesRepositoryImpl(
    private val gameDbService: TheGameDbService
) : GamesRepository {

    override suspend fun getGames(limit: Int, offset: Int, gameIds: List<Int>): List<Game> = coroutineScope {
        val gamesDataModels = gameDbService.getGames(limit = limit, offset = offset, gameIds = gameIds)

        return@coroutineScope gamesDataModels.toGameList(
        )
    }
}

private fun List<GameDataModel>.toGameList(
): List<Game> =
    this.map { gameDataModel ->
        val cover = gameDataModel.cover
        val coverUrl = cover?.url?.getImageUrl()

        val screenshots = gameDataModel.screenshots.map { it.url.getImageUrl() }
        val artworks = gameDataModel.artworks.map { it.url.getImageUrl() }
        val companies = gameDataModel.involvedCompanies.map { it.company }

        Game(
            id = gameDataModel.id.toString(),
            name = gameDataModel.name,
            coverUrl = coverUrl,
            screenshotUrls = screenshots,
            artworkUrls = artworks,
            developmentCompany = companies.firstOrNull()?.name,
            dateOfRelease = gameDataModel.firstReleaseDate?.let { LocalDate.fromEpochDays(it.toInt() / 60 / 60 / 24) },
        )
    }


private fun String.getImageUrl(): String = this.replace("//", "https://").replace("t_thumb", "t_1080p")
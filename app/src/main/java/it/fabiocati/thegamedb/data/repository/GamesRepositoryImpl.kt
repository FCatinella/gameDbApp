package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel
import it.fabiocati.thegamedb.data.model.GameVideoDataModel
import it.fabiocati.thegamedb.data.model.PlatformDataModel
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.domain.model.Platform
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import kotlinx.datetime.LocalDate

class GamesRepositoryImpl(
    private val gameDbService: TheGameDbService
) : GamesRepository {

    override suspend fun getGames(limit: Int, offset: Int, gameIds: List<Int>): List<Game> {
        val gamesDataModels = gameDbService.getGames(limit = limit, offset = offset, gameIds = gameIds)
        return gamesDataModels.toGameList()
    }

    override suspend fun getGameDetails(gameId: Int): GameDetails {
        val gameDataModel = gameDbService.getGameDetail(gameId = gameId)
        return gameDataModel.toModel()
    }

    override suspend fun getSimilarGames(gameId: Int): List<Game> {
        val gameDataModels = gameDbService.getSimilarGames(gameId = gameId)
        return gameDataModels.toGameList()
    }
}

private fun List<GameDataModel>.toGameList(): List<Game> =
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


private fun GameDetailsDataModel.toModel(): GameDetails {
    val artworks = this.artworks.map { it.url.getImageUrl() }
    val companies = this.involvedCompanies.map { it.company }
    val dateOfRelease = this.firstReleaseDate?.let { LocalDate.fromEpochDays(it.toInt() / 60 / 60 / 24) }
    return GameDetails(
        id = this.id.toString(),
        name = this.name,
        artworkUrls = artworks,
        dateOfRelease = dateOfRelease,
        developmentCompany = companies.firstOrNull()?.name,
        platforms = this.platforms.filter { it.abbreviation != null }.map { it.toModel() },
        url = this.websites.firstOrNull {
            //Category 1 means this is the official website url
            //see https://api-docs.igdb.com/?shell#website
            it.category == 1
        }?.url,
        youtubeUrl = this.gameVideos.firstOrNull()?.getYoutubeUrl(),
        summary = this.summary,
        storyline = this.storyline,
    )
}

private fun PlatformDataModel.toModel(): Platform =
    Platform(
        id = id,
        abbreviation = abbreviation ?: "",
        name = name,
        url = url
    )

private fun GameVideoDataModel.getYoutubeUrl(): String {
    return "https://youtube.com/watch?v=${this.videoId}"
}

private fun String.getImageUrl(): String = this.replace("//", "https://").replace("t_thumb", "t_1080p")
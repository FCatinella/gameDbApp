package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.PopularityType
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime

class GetPopularGamesUseCaseImpl(
    private val popularityRepository: PopularityRepository,
    private val gamesRepository: GamesRepository,
) : GetPopularGamesUseCase {

    override suspend operator fun invoke(popularityType: PopularityType, limit: Int, recentGames: Boolean): List<Game> {
        val popularGames = if (recentGames) {
            val sixMonthsAgo = LocalDateTime.sixMonthsAgo()
            popularityRepository.getPopular(limit = limit, popularityType = popularityType, updatedAfter = sixMonthsAgo)
        } else {
            popularityRepository.getPopular(limit = limit, popularityType = popularityType)
        }
        val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })
        return games
    }
}

private fun LocalDateTime.Companion.sixMonthsAgo(): LocalDateTime {
    return Clock.System.now().minus(1, DateTimeUnit.YEAR, TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
}

internal val fakeGame = Game(
    id = "0",
    name = "Red Dead Redemption 2",
    coverUrl = "https://image.api.playstation.com/cdn/UP1004/CUSA03041_00/Hpl5MtwQgOVF9vJqlfui6SDB5Jl4oBSq.png",
    artworkUrls = listOf("https://store-images.s-microsoft.com/image/apps.58752.13942869738016799.078aba97-2f28-440f-97b6-b852e1af307a.95fdf1a1-efd6-4938-8100-8abae91695d6?q=90&w=480&h=270"),
    developmentCompany = "Rockstar Games",
)
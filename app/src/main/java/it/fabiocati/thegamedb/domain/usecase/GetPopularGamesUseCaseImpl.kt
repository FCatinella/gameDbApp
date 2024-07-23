package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.PopularityType
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository

class GetPopularGamesUseCaseImpl(
    private val popularityRepository: PopularityRepository,
    private val gamesRepository: GamesRepository,
) : GetPopularGamesUseCase {

    override suspend operator fun invoke(popularityType: PopularityType, limit: Int): List<Game> {
        val popularGames = popularityRepository.getPopular(limit = limit, popularityType = popularityType)
        val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })
        return games
    }
}
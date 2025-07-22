package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.repository.GamesRepository

class GetSimilarGameUseCaseImpl(
    private val gamesRepository: GamesRepository,
) : GetSimilarGameUseCase {

    override suspend operator fun invoke(gameId: Int): List<Game> {
        val games = gamesRepository.getSimilarGames(gameId = gameId)
        return games

    }
}
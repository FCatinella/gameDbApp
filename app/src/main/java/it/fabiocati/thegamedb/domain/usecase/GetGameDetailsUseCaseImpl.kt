package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.domain.repository.GamesRepository

class GetGameDetailsUseCaseImpl(
    private val gamesRepository: GamesRepository,
) : GetGameDetailsUseCase {

    override suspend fun invoke(gameId: String): GameDetails {
        return gamesRepository.getGameDetails(gameId = gameId.toInt())
    }
}
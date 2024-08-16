package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.GameDetails

interface GetGameDetailsUseCase {
    suspend operator fun invoke(gameId: String): GameDetails
}
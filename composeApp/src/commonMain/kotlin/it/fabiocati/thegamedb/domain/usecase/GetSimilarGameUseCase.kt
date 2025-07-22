package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Game

interface GetSimilarGameUseCase {
    suspend operator fun invoke(gameId: Int): List<Game>
}
package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Event

interface GetEventsUseCase {
    suspend operator fun invoke(gameId: String): List<Event>
}
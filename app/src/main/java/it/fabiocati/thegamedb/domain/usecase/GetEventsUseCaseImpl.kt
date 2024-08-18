package it.fabiocati.thegamedb.domain.usecase

import it.fabiocati.thegamedb.domain.model.Event
import it.fabiocati.thegamedb.domain.repository.EventRepository

class GetEventsUseCaseImpl(
    private val eventRepository: EventRepository,
) : GetEventsUseCase {

    override suspend fun invoke(gameId: String): List<Event> {
        return eventRepository.getEvents(gameId = gameId.toInt())
    }
}
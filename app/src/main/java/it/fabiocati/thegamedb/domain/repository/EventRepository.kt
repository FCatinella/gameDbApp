package it.fabiocati.thegamedb.domain.repository

import it.fabiocati.thegamedb.domain.model.Event

interface EventRepository {
    suspend fun getEvents(gameId: Int): List<Event>
}
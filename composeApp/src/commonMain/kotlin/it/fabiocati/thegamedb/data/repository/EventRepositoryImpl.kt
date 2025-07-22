package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.EventDataModel
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.Event
import it.fabiocati.thegamedb.domain.repository.EventRepository
import it.fabiocati.thegamedb.utils.extensions.getImageUrl
import kotlinx.datetime.LocalDate

class EventRepositoryImpl(
    private val gameDbService: TheGameDbService
) : EventRepository {
    override suspend fun getEvents(gameId: Int): List<Event> {
        val dataModels = gameDbService.getEvents(gameId)
        return dataModels.map {
            it.toModel()
        }
    }
}

private fun EventDataModel.toModel(): Event {
    return Event(
        id = this.id,
        name = this.name,
        description = this.description,
        logo = this.eventLogo?.url?.getImageUrl(),
        startTime = this.startTime?.let { LocalDate.fromEpochDays(it / 60 / 60 / 24) },
        liveStreamUrl = this.liveStreamUrl
    )
}
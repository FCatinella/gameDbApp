package it.fabiocati.thegamedb.data.repository

import it.fabiocati.thegamedb.data.model.SortMode
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.PopularityPrimitive
import it.fabiocati.thegamedb.domain.model.PopularityType
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

class PopularityRepositoryImpl(
    private val gameDbService: TheGameDbService
) : PopularityRepository {
    override suspend fun getPopular(limit: Int, popularityType: PopularityType, sortMode: SortMode, updatedAfter: LocalDateTime): List<PopularityPrimitive> {
        val popularityPrimitiveDataModel = gameDbService.getPopular(popularityType = popularityType.id, sort = sortMode.raw, limit = limit, updateDateTime = updatedAfter.toMillis())
        return popularityPrimitiveDataModel.map {
            PopularityPrimitive(
                id = it.id,
                gameId = it.gameId,
                popularityType = PopularityType.entries.firstOrNull { type -> type.id == it.popularityType }!!,
                value = it.value
            )
        }
    }
}

private fun LocalDateTime.toMillis(): Long {
    return this.toInstant(TimeZone.UTC).epochSeconds
}
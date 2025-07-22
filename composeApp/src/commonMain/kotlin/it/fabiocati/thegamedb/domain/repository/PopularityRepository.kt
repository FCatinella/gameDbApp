package it.fabiocati.thegamedb.domain.repository

import it.fabiocati.thegamedb.data.model.SortMode
import it.fabiocati.thegamedb.domain.model.PopularityPrimitive
import it.fabiocati.thegamedb.domain.model.PopularityType
import kotlinx.datetime.LocalDateTime

interface PopularityRepository {

    suspend fun getPopular(limit: Int, popularityType: PopularityType, sortMode: SortMode = SortMode.DESC, updatedAfter: LocalDateTime = LocalDateTime(1970,1,1,0,0)): List<PopularityPrimitive>
}
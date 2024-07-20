package it.fabiocati.thegamedb.domain.repository

import it.fabiocati.thegamedb.data.model.PopularityType
import it.fabiocati.thegamedb.data.model.SortMode
import it.fabiocati.thegamedb.domain.model.PopularityPrimitive

interface PopularityRepository {

    suspend fun getPopular(limit: Int, offset: Int = 0, popularityType: PopularityType, sortMode: SortMode = SortMode.DESC): List<PopularityPrimitive>
}
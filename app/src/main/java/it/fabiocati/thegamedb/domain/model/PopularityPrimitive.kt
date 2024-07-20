package it.fabiocati.thegamedb.domain.model

import it.fabiocati.thegamedb.data.model.PopularityType

data class PopularityPrimitive(
    val id: Int,
    val gameId: Int,
    val popularityType: PopularityType,
    val value: Float
)
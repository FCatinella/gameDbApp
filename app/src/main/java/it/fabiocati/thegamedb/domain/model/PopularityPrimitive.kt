package it.fabiocati.thegamedb.domain.model

data class PopularityPrimitive(
    val id: Int,
    val gameId: Int,
    val popularityType: PopularityType,
    val value: Float
)
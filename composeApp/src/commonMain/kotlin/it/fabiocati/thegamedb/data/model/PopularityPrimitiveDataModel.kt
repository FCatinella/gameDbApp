package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularityPrimitiveDataModel(
    @SerialName("id")
    val id: Int,
    @SerialName("game_id")
    val gameId: Int,
    @SerialName("popularity_type")
    val popularityType: Int? = null,
    @SerialName("value")
    val value: Float,
)
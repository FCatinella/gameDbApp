package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDataModel(
    @SerialName("id")
    val id : Int,
    @SerialName("game")
    val gameId: String,
    @SerialName("image_id")
    val imageId: String,
    @SerialName("url")
    val url: String
)
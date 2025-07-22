package it.fabiocati.thegamedb.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WebsiteDataModel(
    @SerialName("category")
    val category: Int = 1,
    @SerialName("checksum")
    val checksum: String,
    @SerialName("game")
    val game: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("trusted")
    val trusted: Boolean,
    @SerialName("url")
    val url: String
)
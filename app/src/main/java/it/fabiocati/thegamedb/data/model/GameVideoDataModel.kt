package it.fabiocati.thegamedb.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameVideoDataModel(
    @SerialName("checksum")
    val checksum: String,
    @SerialName("game")
    val game: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("video_id")
    val videoId: String
)
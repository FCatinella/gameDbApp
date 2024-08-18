package it.fabiocati.thegamedb.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventDataModel(
    @SerialName("checksum")
    val checksum: String,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("description")
    val description: String? = null,
    @SerialName("event_logo")
    val eventLogo: EventLogoDataModel? = null,
    @SerialName("games")
    val games: List<Int>,
    @SerialName("id")
    val id: Int,
    @SerialName("live_stream_url")
    val liveStreamUrl: String? = null,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("start_time")
    val startTime: Int? = null,
    @SerialName("time_zone")
    val timeZone: String,
    @SerialName("updated_at")
    val updatedAt: Int,
)

@Serializable
data class EventLogoDataModel(
    @SerialName("alpha_channel")
    val alphaChannel: Boolean,
    @SerialName("animated")
    val animated: Boolean,
    @SerialName("checksum")
    val checksum: String,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("event")
    val event: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image_id")
    val imageId: String,
    @SerialName("updated_at")
    val updatedAt: Int,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int
)
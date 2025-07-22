package it.fabiocati.thegamedb.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformDataModel(
    @SerialName("abbreviation")
    val abbreviation: String? = null,
    @SerialName("category")
    val category: Int,
    @SerialName("checksum")
    val checksum: String,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("platform_logo")
    val platformLogo: Int,
    @SerialName("slug")
    val slug: String,
    @SerialName("updated_at")
    val updatedAt: Int,
    @SerialName("url")
    val url: String,
    @SerialName("versions")
    val versions: List<Int>
)
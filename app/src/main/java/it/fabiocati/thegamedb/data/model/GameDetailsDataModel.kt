package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDetailsDataModel(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("artworks")
    val artworks: List<ImageDataModel> = emptyList(),
    @SerialName("first_release_date")
    val firstReleaseDate: String? = null,
    @SerialName("involved_companies")
    val involvedCompanies: List<InvolvedCompanyDataModel> = emptyList(),
    @SerialName("platforms")
    val platforms: List<PlatformDataModel> = emptyList(),
    @SerialName("websites")
    val websites: List<WebsiteDataModel> = emptyList(),
    @SerialName("videos")
    val gameVideos: List<GameVideoDataModel> = emptyList(),
)
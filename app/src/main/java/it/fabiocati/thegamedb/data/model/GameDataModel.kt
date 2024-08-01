package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDataModel(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("cover")
    val cover: ImageDataModel? = null,
    @SerialName("screenshots")
    val screenshots: List<ImageDataModel> = emptyList(),
    @SerialName("artworks")
    val artworks: List<ImageDataModel> = emptyList(),
    @SerialName("involved_companies")
    val involvedCompanies: List<InvolvedCompanyDataModel> = emptyList(),
    @SerialName("first_release_date")
    val firstReleaseDate: String? = null,
)
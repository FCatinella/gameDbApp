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
    val cover: Int? = null,
    @SerialName("screenshots")
    val screenshots: List<Int> = emptyList(),
    @SerialName("artworks")
    val artworks: List<Int> = emptyList(),
    @SerialName("involved_companies")
    val involvedCompanies: List<Int> = emptyList(),
    @SerialName("first_release_date")
    val firstReleaseDate: String? = null,
)
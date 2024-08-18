package it.fabiocati.thegamedb.domain.model

import kotlinx.datetime.LocalDate

data class GameDetails(
    val id: String,
    val name: String,
    val coverUrl: String? = null,
    val screenshotUrls: List<String> = emptyList(),
    val artworkUrls: List<String> = emptyList(),
    val developmentCompany: String? = null,
    val genre: String? = null,
    val dateOfRelease: LocalDate? = null,
    val platforms: List<Platform> = emptyList(),
    val url: String? = null,
    val youtubeUrl: String? = null,
    val storyline: String? = null,
    val summary: String? = null
)
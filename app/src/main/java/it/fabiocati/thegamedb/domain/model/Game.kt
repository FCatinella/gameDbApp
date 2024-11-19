package it.fabiocati.thegamedb.domain.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

data class Game(
    val id: String,
    val name: String,
    val coverUrl: String? = null,
    val screenshotUrls: List<String> = emptyList(),
    val artworkUrls: List<String> = emptyList(),
    val developmentCompany: String? = null,
    val genre: String? = null,
    val dateOfRelease: LocalDate? = null,
)
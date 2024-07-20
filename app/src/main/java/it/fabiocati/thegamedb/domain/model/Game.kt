package it.fabiocati.thegamedb.domain.model

data class Game(
    val id: String,
    val name: String,
    val coverUrl: String? = null,
    val screenshotUrls: List<String> = emptyList(),
    val artworkUrls: List<String> = emptyList()
)
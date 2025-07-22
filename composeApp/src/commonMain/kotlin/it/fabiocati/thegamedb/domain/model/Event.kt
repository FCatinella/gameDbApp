package it.fabiocati.thegamedb.domain.model

import kotlinx.datetime.LocalDate

data class Event(
    val id: Int,
    val name: String,
    val description: String? = null,
    val logo: String? = null,
    val startTime: LocalDate? = null,
    val liveStreamUrl: String? = null
)
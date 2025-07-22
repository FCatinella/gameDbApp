package it.fabiocati.thegamedb.navigation

import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object Home
    @Serializable
    data class Detail(val gameId: String)
}

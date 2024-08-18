package it.fabiocati.thegamedb.ui.details

import it.fabiocati.thegamedb.domain.model.Event
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.GameDetails

data class GameDetailsUiState(
    val gameDetails: GameDetails? = null,
    val similarGames: List<Game> = emptyList(),
    val relatedEvents: List<Event> = emptyList()
)
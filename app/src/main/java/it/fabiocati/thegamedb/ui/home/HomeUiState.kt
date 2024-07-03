package it.fabiocati.thegamedb.ui.home

import it.fabiocati.thegamedb.domain.model.Game

data class HomeUiState(
    val games: List<Game> = emptyList()
)
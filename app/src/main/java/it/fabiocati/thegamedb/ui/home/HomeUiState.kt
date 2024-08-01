package it.fabiocati.thegamedb.ui.home

import it.fabiocati.thegamedb.domain.model.Game

data class HomeUiState(
    val wantedToPlayGames: List<Game> = emptyList(),
    val nowPlayingGames: List<Game> = emptyList(),
    val mostVisitedGames: List<Game> = emptyList(),
    val mostPlayedGames: List<Game> = emptyList()
)
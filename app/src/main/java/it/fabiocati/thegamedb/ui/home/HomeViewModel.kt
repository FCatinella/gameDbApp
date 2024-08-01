package it.fabiocati.thegamedb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.fabiocati.thegamedb.domain.model.PopularityType
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularGamesUseCase: GetPopularGamesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getWantedGames()
        getMostPlayedGames()
        getMostVisitedGames()
        getMostPlayingGames()
    }

    fun getWantedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = getPopularGamesUseCase(PopularityType.WANT_TO_PLAY)
            _uiState.update {
                it.copy(wantedToPlayGames = games)
            }
        }
    }

    fun getMostPlayedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = getPopularGamesUseCase(PopularityType.PLAYED)
            _uiState.update {
                it.copy(mostPlayedGames = games)
            }
        }
    }

    fun getMostVisitedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = getPopularGamesUseCase(PopularityType.VISITS)
            _uiState.update {
                it.copy(mostVisitedGames = games)
            }
        }
    }

    fun getMostPlayingGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = getPopularGamesUseCase(PopularityType.PLAYING)

            _uiState.update {
                it.copy(nowPlayingGames = games)
            }
        }
    }
}
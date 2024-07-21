package it.fabiocati.thegamedb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.fabiocati.thegamedb.data.model.PopularityType
import it.fabiocati.thegamedb.domain.repository.GamesRepository
import it.fabiocati.thegamedb.domain.repository.PopularityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val gamesRepository: GamesRepository,
    private val popularityRepository: PopularityRepository,
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
            val popularGames = popularityRepository.getPopular(limit = 15, popularityType = PopularityType.WANT_TO_PLAY)
            val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })

            _uiState.update {
                it.copy(wantedToPlayGames = games)
            }
        }
    }

    fun getMostPlayedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val popularGames = popularityRepository.getPopular(limit = 15, popularityType = PopularityType.PLAYED)
            val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })

            _uiState.update {
                it.copy(mostPlayedGames = games)
            }
        }
    }

    fun getMostVisitedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val popularGames = popularityRepository.getPopular(limit = 15, popularityType = PopularityType.VISITS)
            val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })

            _uiState.update {
                it.copy(mostVisitedGames = games)
            }
        }
    }

    fun getMostPlayingGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val popularGames = popularityRepository.getPopular(limit = 15, popularityType = PopularityType.PLAYING)
            val games = gamesRepository.getGames(limit = popularGames.size, gameIds = popularGames.map { it.gameId })

            _uiState.update {
                it.copy(nowPlayingGames = games)
            }
        }
    }
}
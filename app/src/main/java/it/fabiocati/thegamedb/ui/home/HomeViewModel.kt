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
        getGames()
    }

    fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val popularGames = popularityRepository.getPopular(limit = 10, offset = 10, popularityType = PopularityType.WANT_TO_PLAY)
            val games = gamesRepository.getGames(limit = 10, gameIds = popularGames.map { it.gameId })

            _uiState.update {
                it.copy(games = games)
            }
        }
    }
}
package it.fabiocati.thegamedb.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetSimilarGameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
    private val getSimilarGameUseCase: GetSimilarGameUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun init(gameId: String) {
        getGameDetails(gameId)
        getSimilarGames(gameId)
    }

    private fun getGameDetails(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val gameDetails = getGameDetailsUseCase.invoke(gameId)
            _uiState.update {
                it.copy(gameDetails = gameDetails)
            }
        }
    }

    private fun getSimilarGames(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val similarGames = getSimilarGameUseCase.invoke(gameId.toInt())
            _uiState.update {
                it.copy(similarGames = similarGames)
            }
        }
    }
}
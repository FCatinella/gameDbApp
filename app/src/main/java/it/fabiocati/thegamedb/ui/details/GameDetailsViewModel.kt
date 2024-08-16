package it.fabiocati.thegamedb.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailsUiState())
    val uiState = _uiState.asStateFlow()

    private val selectedGameId: String?
        get() = _uiState.value.gameDetails?.id

    fun init(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val gameDetails = getGameDetailsUseCase.invoke(gameId)
            _uiState.update {
                it.copy(gameDetails = gameDetails)
            }
        }
    }
}
package it.fabiocati.thegamedb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.fabiocati.thegamedb.data.network.TheGameDbService
import it.fabiocati.thegamedb.domain.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val gameDbService: TheGameDbService) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getGames()
    }

    fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val gamesDataModels = gameDbService.getGames(limit = 50, offset = 30)
            val gameIds = gamesDataModels.map { it.id }
            val coverIds = gamesDataModels.mapNotNull { it.cover }
            val screenshotIds = gamesDataModels.flatMap { it.screenshots }

            val coverDataModels = gameDbService.getCovers(*coverIds.toIntArray())
            val screenshotsDataModels = gameDbService.getScreenshots(*screenshotIds.toIntArray())

            val games = gamesDataModels.map { dataModel ->
                val cover = coverDataModels.firstOrNull { it.id == dataModel.cover }
                val coverUrl = cover?.url?.replace("//", "https://")?.replace("t_thumb", "t_1080p")

                val screenshots = screenshotsDataModels.filter { dataModel.screenshots.contains(it.id) }.map { it.url.replace("//", "https://").replace("t_thumb", "t_1080p") }
                Game(
                    id = dataModel.id.toString(),
                    name = dataModel.name,
                    coverUrl = coverUrl,
                    screenshotsUrl = screenshots
                )
            }

            _uiState.update {
                it.copy(games = games)
            }
        }
    }
}
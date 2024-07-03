package it.fabiocati.thegamedb.ui.home

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import it.fabiocati.thegamedb.domain.model.Game

@Destination<RootGraph>(start = true)
@Composable
fun HomeRoute() {
    val games = listOf(
        Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
        Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
        Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
        Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null)
    )
    HomeScreen(
        uiState = HomeUiState(games = games)
    )
}



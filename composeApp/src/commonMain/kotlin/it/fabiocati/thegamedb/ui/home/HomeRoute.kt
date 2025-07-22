package it.fabiocati.thegamedb.ui.home

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import it.fabiocati.thegamedb.LocalWindowWidthSizeClass
import it.fabiocati.thegamedb.navigation.Routes
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = koinViewModel(),
    navigator: NavController,
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
            HomeScreenMedium(
                uiState = uiState,
                onGamePressed = { game ->
                    navigator.navigate(Routes.Detail(gameId = game.id))
                }
            )
        }

        else -> {
            HomeScreen(
                uiState = uiState,
                onGamePressed = { game ->
                    navigator.navigate(Routes.Detail(gameId = game.id))
                }
            )
        }
    }

}
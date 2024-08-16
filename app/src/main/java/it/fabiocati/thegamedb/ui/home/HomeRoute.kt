package it.fabiocati.thegamedb.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.GameDetailsRouteDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination<RootGraph>(start = true)
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = koinViewModel(),
    navigator: DestinationsNavigator,
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        onGamePressed = { game ->
            navigator.navigate(GameDetailsRouteDestination(gameId = game.id))
        }
    )
}



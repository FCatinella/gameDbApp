package it.fabiocati.thegamedb.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import it.fabiocati.thegamedb.navigation.Routes
import org.koin.compose.viewmodel.koinViewModel

/*@Destination<RootGraph>(
    deepLinks = [
        DeepLink(
            uriPattern = "app://gamedb.fabiocati.it/{gameId}"
        )
    ]
)*/
@Composable
fun GameDetailsRoute(
    gameId: String,
    gameDetailsViewModel: GameDetailsViewModel = koinViewModel<GameDetailsViewModel>(),
    navigator: NavController,
) {

    val uiState by gameDetailsViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        gameDetailsViewModel.init(gameId)
    }

    GameDetailsScreen(
        uiState = uiState,
        onBackPressed = {
            navigator.navigateUp()
        },
        onTrailerPressed = gameDetailsViewModel::openUrl,
        onWebsitePressed = gameDetailsViewModel::openUrl,
        onPlatformPressed = {
            gameDetailsViewModel.openUrl(it.url)
        },
        onSimilarGamePressed = {
            navigator.navigate(Routes.Detail(gameId = it.id))
        }
    )
}

package it.fabiocati.thegamedb.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import it.fabiocati.thegamedb.utils.extensions.openExternalUrl
import org.koin.androidx.compose.koinViewModel

@Destination<RootGraph>
@Composable
fun GameDetailsRoute(
    gameId: String,
    gameDetailsViewModel: GameDetailsViewModel = koinViewModel<GameDetailsViewModel>(),
    navigator: DestinationsNavigator,
) {

    val uiState by gameDetailsViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        gameDetailsViewModel.init(gameId)
    }

    GameDetailsScreen(
        gameDetails = uiState.gameDetails,
        onBackPressed = {
            navigator.navigateUp()
        },
        onTrailerPressed = {
            context.openExternalUrl(it)
        },
        onWebsitePressed = {
            context.openExternalUrl(it)
        },
        onPlatformPressed = {
            context.openExternalUrl(it.url)
        }
    )
}

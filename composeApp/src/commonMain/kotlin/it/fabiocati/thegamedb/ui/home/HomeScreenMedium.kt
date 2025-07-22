package it.fabiocati.thegamedb.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gamedbapp.composeapp.generated.resources.Res
import gamedbapp.composeapp.generated.resources.igdb_logo
import gamedbapp.composeapp.generated.resources.most_played
import gamedbapp.composeapp.generated.resources.most_visited
import gamedbapp.composeapp.generated.resources.now_playing
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.components.HomeBannerHorizontalPager
import it.fabiocati.thegamedb.ui.components.HomeCoverHorizontalList
import it.fabiocati.thegamedb.ui.components.PlatformRow
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenMedium(
    uiState: HomeUiState,
    onGamePressed: (Game) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        LazyColumn(
            contentPadding = WindowInsets.navigationBars.asPaddingValues()
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(Res.drawable.igdb_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .width(100.dp)
                            .aspectRatio(2.1f)
                            .align(Alignment.Center)
                            .padding(top = 6.dp)
                    )
                }
            }
            item {
                HomeBannerHorizontalPager(
                    games = uiState.wantedToPlayGames,
                    onGamePressed = onGamePressed
                )
            }
            item {
                PlatformRow()
            }
            item {
                HomeCoverHorizontalList(
                    title = stringResource(Res.string.most_played),
                    games = uiState.mostPlayedGames,
                    onGamePressed = onGamePressed,
                )
            }
            item {
                HomeCoverHorizontalList(
                    title = stringResource(Res.string.now_playing),
                    games = uiState.nowPlayingGames,
                    onGamePressed = onGamePressed,
                )
            }
            item {
                HomeCoverHorizontalList(
                    title = stringResource(Res.string.most_visited),
                    games = uiState.mostVisitedGames,
                    onGamePressed = onGamePressed,
                )
            }
        }
    }
}

@Composable
private fun HomeScreenPreview() {
    val games = listOf(
        Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null)
    )
    val uiState = HomeUiState(
        wantedToPlayGames = games, mostPlayedGames = games, nowPlayingGames = games, mostVisitedGames = games
    )
    TheGameDbTheme {
        HomeScreen(uiState = uiState, onGamePressed = {})
    }
}


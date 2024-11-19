package it.fabiocati.thegamedb.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.components.GameDbImage
import it.fabiocati.thegamedb.ui.components.HomeBannerHorizontalPager
import it.fabiocati.thegamedb.ui.components.HomeCoverHorizontalList
import it.fabiocati.thegamedb.ui.components.PlatformRow
import it.fabiocati.thegamedb.ui.components.PlatformSection
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import it.fabiocati.thegamedb.utils.extensions.resourceUri

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenMedium(
    uiState: HomeUiState,
    onGamePressed: (Game) -> Unit,
) {
    val context = LocalContext.current

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
                    GameDbImage(
                        model = context.resourceUri(R.drawable.igdb_logo),
                        previewResourceId = R.drawable.igdb_logo,
                        isCrossFadeEnable = false,
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
                    title = stringResource(R.string.most_played),
                    games = uiState.mostPlayedGames,
                    onGamePressed = onGamePressed,
                )
            }
            item {
                HomeCoverHorizontalList(
                    title = stringResource(R.string.now_playing),
                    games = uiState.nowPlayingGames,
                    onGamePressed = onGamePressed,
                )
            }
            item {
                HomeCoverHorizontalList(
                    title = stringResource(R.string.most_visited),
                    games = uiState.mostVisitedGames,
                    onGamePressed = onGamePressed,
                )
            }
        }
    }
}

@Preview(device = Devices.PIXEL_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_5)
@Composable
private fun HomeScreenPreview() {
    val games = listOf(
        Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null), Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null), Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null), Game(id = "001", name = "Red Dead Redemption 2", coverUrl = null)
    )
    val uiState = HomeUiState(
        wantedToPlayGames = games, mostPlayedGames = games, nowPlayingGames = games, mostVisitedGames = games
    )
    TheGameDbTheme {
        HomeScreen(uiState = uiState, onGamePressed = {})
    }
}


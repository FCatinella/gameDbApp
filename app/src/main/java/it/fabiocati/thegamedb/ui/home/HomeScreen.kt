package it.fabiocati.thegamedb.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.components.HomeBannerHorizontalPager

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        LazyColumn {
            item {
                HomeBannerHorizontalPager(games = uiState.games)
            }
        }
    }
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun HomeScreenPreview() {
    val uiState = HomeUiState(
        games = listOf(
            Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
            Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
            Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null),
            Game(id = "001", name = "Dragon Ball: Sparking! Zero", coverUrl = null)
        )
    )
    HomeScreen(uiState = uiState)
}


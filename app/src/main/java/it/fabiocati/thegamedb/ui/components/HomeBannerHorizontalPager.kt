package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBannerHorizontalPager(
    games: List<Game>,
    state: PagerState = rememberPagerState(pageCount = { games.size }),
) {
    HorizontalPager(
        state = state,
        contentPadding = PaddingValues(16.dp),
        pageSpacing = 8.dp
    ) { index ->
        val game = games[index]
        HomeBannerElement(
            game = game,
        )
    }

}

@Composable
private fun HomeBannerElement(
    game: Game,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Box(
            modifier = Modifier
                .aspectRatio(1.5f)
        ) {
            Text(
                text = game.name,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(16.dp)
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun HomeBannerHorizontalPagerPreview() {
    val games = listOf(
        Game(id = "Tommy", name = "Dragon ball: Sparking! Zero", coverUrl = null),
        Game(id = "Tommy", name = "Dragon ball: Sparking! Zero", coverUrl = null),
        Game(id = "Tommy", name = "Dragon ball: Sparking! Zero", coverUrl = null),
        Game(id = "Tommy", name = "Dragon ball: Sparking! Zero", coverUrl = null)
    )

    HomeBannerHorizontalPager(
        games = games
    )
}

@Preview(Devices.PIXEL_5)
@Composable
private fun HomeBannerElementPreview() {
    val game = Game(id = "Tommy", name = "Dragon ball: Sparking! Zero", coverUrl = null)
    TheGameDbTheme {
        HomeBannerElement(game)

    }
}
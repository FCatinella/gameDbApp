package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import kotlinx.datetime.LocalDate

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
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(0.8f)
        ) {
            GameDbImage(
                model = game.artworkUrls.firstOrNull() ?: game.screenshotUrls.firstOrNull() ?: game.coverUrl ?: "",
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.8f),
                                Color.Transparent
                            ),
                        )
                    )
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(fraction = 0.8f)
                    .padding(16.dp)
            ) {
                Text(
                    text = game.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = game.developmentCompany ?: "",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${game.dateOfRelease?.year ?: "N/A"}",
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun HomeBannerHorizontalPagerPreview() {
    val games = listOf(
        Game(
            id = "Tommy", name = "Red Dead Redemption 2",
            coverUrl = null,
            dateOfRelease = LocalDate(year = 2018, monthNumber = 1, dayOfMonth = 1),
            developmentCompany = "Rockstar Games"
        ),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
    )

    HomeBannerHorizontalPager(
        games = games
    )
}

@Preview(Devices.PIXEL_5)
@Composable
private fun HomeBannerElementPreview() {
    val game = Game(
        id = "Tommy",
        name = "Dragon ball: Sparking! Zero",
        coverUrl = null,
        dateOfRelease = LocalDate(year = 2018, monthNumber = 1, dayOfMonth = 1),
        developmentCompany = "Bandai Namco"
    )
    TheGameDbTheme {
        HomeBannerElement(game)

    }
}
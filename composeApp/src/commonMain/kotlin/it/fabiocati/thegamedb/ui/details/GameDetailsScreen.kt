package it.fabiocati.thegamedb.ui.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.domain.model.Platform
import it.fabiocati.thegamedb.ui.components.ActionButton
import it.fabiocati.thegamedb.ui.components.BackButton
import it.fabiocati.thegamedb.ui.components.GameDbImage
import it.fabiocati.thegamedb.ui.components.GameDbTabRow
import it.fabiocati.thegamedb.ui.components.LoadingText
import it.fabiocati.thegamedb.ui.components.PlatformBox
import it.fabiocati.thegamedb.ui.components.SecondaryButton
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import it.fabiocati.thegamedb.utils.extensions.getBottomDp
import it.fabiocati.thegamedb.utils.extensions.getTopDp
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
@Composable
fun GameDetailsScreen(
    uiState: GameDetailsUiState,
    onPlatformPressed: (Platform) -> Unit,
    onWebsitePressed: (String) -> Unit,
    onTrailerPressed: (String) -> Unit,
    onSimilarGamePressed: (Game) -> Unit,
    onBackPressed: () -> Unit,
) {

    val gameDetails = uiState.gameDetails
    val similarGames = uiState.similarGames

    val colorStops = arrayOf(
        0.0f to Color.Transparent,
        0.6f to Color.Transparent,
        1f to MaterialTheme.colorScheme.surfaceVariant
    )

    val pagerState = rememberPagerState(initialPage = 0) { 3 }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = WindowInsets.systemBars.getBottomDp() + 8.dp)
        ) {
            item {
                GameDbImage(
                    model = gameDetails?.artworkUrls?.firstOrNull(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .drawWithContent {
                            drawContent()
                            drawRect(Brush.verticalGradient(colorStops = colorStops))
                        }
                        .fillMaxWidth()
                        .aspectRatio(1.2f)
                )
            }
            item {
                LoadingText(
                    text = gameDetails?.name,
                    placeholderText = "The Last of Us part 2",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.6f)
                        .offset(y = (-24).dp)
                )
            }
            item {
                FlowRow(
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.offset(y = (-20).dp)
                ) {
                    LoadingText(
                        text = gameDetails?.let { "${gameDetails.dateOfRelease?.year ?: "N/A"}" },
                        placeholderText = "2018",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    LoadingText(
                        text = gameDetails?.let { gameDetails.developmentCompany ?: "N/A" },
                        placeholderText = "Naughty Dog",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            }
            item {
                val platformList = gameDetails?.platforms ?: emptyList()
                FlowRow(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .offset(y = (-14).dp)
                        .padding(horizontal = 12.dp)
                ) {
                    platformList.forEach {
                        PlatformBox(
                            text = it.abbreviation,
                            modifier = Modifier.padding(4.dp),
                            onClick = {
                                onPlatformPressed(it)
                            }
                        )
                    }
                }
            }
            item {
                ActionButton(
                    text = "Play", onClick = { },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                )
            }
            item {
                FlowRow {
                    SecondaryButton(
                        iconVector = Icons.Default.Link,
                        text = "Website",
                        modifier = Modifier.padding(10.dp),
                        onClick = { gameDetails?.url?.let { url -> onWebsitePressed(url) } }
                    )

                    SecondaryButton(
                        iconVector = Icons.Default.Movie,
                        text = "Trailer",
                        modifier = Modifier.padding(10.dp),
                        onClick = { gameDetails?.youtubeUrl?.let { url -> onTrailerPressed(url) } }
                    )
                }
            }
            item {
                LoadingText(
                    text = gameDetails?.let { gameDetails -> gameDetails.summary ?: "N/A" },
                    placeholderText =
                    """
                    Red Dead Redemption 2 is the epic tale of outlaw Arthur Morgan and the infamous Van der Linde gang, on the run across America at the dawn of the modern age. """.trimIndent(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                val currentPagerPage by remember {
                    derivedStateOf {
                        pagerState.currentPage
                    }
                }
                val scrollCoroutineScope = rememberCoroutineScope()

                GameDbTabRow(
                    selectedTabIndex = currentPagerPage,
                    onTabClick = { tabIndex ->
                        scrollCoroutineScope.launch {
                            pagerState.scrollToPage(tabIndex)
                        }
                    },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
            item {
                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = false
                ) { index ->
                    when (index) {
                        0 -> SimilarGamesGrid(
                            similarGames = similarGames,
                            onGamePressed = onSimilarGamePressed,
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )

                        1 -> {
                            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                                uiState.relatedEvents.forEach { event ->
                                    RelatedEventComponent(
                                        event = event,
                                        modifier = Modifier.padding(vertical = 16.dp)
                                    )
                                }
                            }
                        }

                        2 -> {
                            GameDetailsInfoComponent(
                                gameDetails = gameDetails,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
                            )
                        }
                    }

                }
            }
        }
        BackButton(
            modifier = Modifier
                .padding(top = WindowInsets.statusBars.getTopDp())
                .padding(8.dp),
            onClick = onBackPressed
        )
    }
}

@Composable
private fun GameDetailsScreenPreview() {
    TheGameDbTheme {
        val uiState = GameDetailsUiState(
            gameDetails = GameDetails(id = "Cassondra", name = "Raelene", coverUrl = null, screenshotUrls = listOf(), artworkUrls = listOf(), developmentCompany = null, genre = null, dateOfRelease = null, platforms = listOf(), url = null, youtubeUrl = null, storyline = null, summary = null)
        )
        GameDetailsScreen(
            uiState = uiState,
            onPlatformPressed = {},
            onWebsitePressed = {},
            onTrailerPressed = {},
            onSimilarGamePressed = {},
            onBackPressed = {}
        )
    }
}
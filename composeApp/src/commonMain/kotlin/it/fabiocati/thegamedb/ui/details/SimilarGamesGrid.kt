package it.fabiocati.thegamedb.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.components.GameCover
import it.fabiocati.thegamedb.ui.components.Grid
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun SimilarGamesGrid(
    similarGames: List<Game>,
    onGamePressed: (Game) -> Unit,
    modifier: Modifier = Modifier,
) {
    Grid(
        items = similarGames,
        columns = 2,
        modifier = modifier
    ) { item, index ->
        val isOnLeft = index % 2 == 0
        GameCover(
            game = item,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.7f)
                .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = if (isOnLeft) 0.dp else 8.dp,
                    end = if (isOnLeft) 8.dp else 0.dp
                )
                .clickable { onGamePressed(item) }
        )
    }
}

@Composable
private fun RecommendedGridPreview() {
    val similarGames = emptyList<Game>(
       // redDeadRedemption2, redDeadRedemption2, redDeadRedemption2
    )
    TheGameDbTheme {
        SimilarGamesGrid(
            similarGames = similarGames,
            onGamePressed = {}
        )
    }
}
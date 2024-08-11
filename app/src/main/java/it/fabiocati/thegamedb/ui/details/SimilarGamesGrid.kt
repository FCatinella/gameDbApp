package it.fabiocati.thegamedb.ui.details

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.ui.components.GameCover
import it.fabiocati.thegamedb.ui.components.Grid
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import it.fabiocati.thegamedb.utils.redDeadRedemption2

@Composable
fun SimilarGamesGrid(
    modifier: Modifier = Modifier,
) {
    val games = remember { (1..8).map { redDeadRedemption2 } }
    Grid(
        items = games,
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
                    start = if(isOnLeft) 0.dp else 8.dp,
                    end = if(isOnLeft) 8.dp else 0.dp
                )
        )
    }
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun RecommendedGridPreview() {
    TheGameDbTheme {
        SimilarGamesGrid()
    }
}
package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun GameCover(
    game: Game,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillHeight
) {
    GameDbImage(
        model = game.coverUrl ?: "",
        contentScale = contentScale,
        modifier = modifier
            .clip(
                RoundedCornerShape(4.dp)
            ),
        isCrossFadeEnable = false,
        previewResourceId = R.drawable.preview_cover_image
    )
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun GameCoverPreview() {
    val game = Game(id = "Cal", name = "Baldemar", coverUrl = null, screenshotUrls = listOf(), artworkUrls = listOf())
    TheGameDbTheme {
        GameCover(game)
    }
}
package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import gamedbapp.composeapp.generated.resources.Res
import gamedbapp.composeapp.generated.resources.preview_cover_image
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
        previewResourceId = Res.drawable.preview_cover_image
    )
}

@Composable
private fun GameCoverPreview() {
    val game = Game(id = "Cal", name = "Baldemar", coverUrl = null, screenshotUrls = listOf(), artworkUrls = listOf())
    TheGameDbTheme {
        GameCover(game)
    }
}
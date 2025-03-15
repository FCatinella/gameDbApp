package it.fabiocati.thegamedb.widget.randomGame.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.widget.randomGame.fakeGame
import it.fabiocati.thegamedb.widget.ui.components.AsyncWidgetImage

@Composable
internal fun RandomGameWidgetContentExpanded(
    game: GameDetails,
) {

    Scaffold(
        titleBar = {
            TitleBar(
                startIcon = ImageProvider(R.drawable.igdb_logo),
                title = "Random Game"
            )
        }
    ) {
        Column {
            AsyncWidgetImage(
                data = game.artworkUrls.firstOrNull() ?: "",
                contentDescription = null,
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(GlanceTheme.colors.primary)
                    .cornerRadius(8.dp)
            )
            Spacer(modifier = GlanceModifier.height(8.dp))
            Column {
                Text(
                    text = game.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = GlanceTheme.colors.onBackground
                    )
                )
                Spacer(modifier = GlanceModifier.height(2.dp))
                Text(
                    text = (game.summary?.take(205) + "..."),
                    style = TextStyle(
                        color = GlanceTheme.colors.onBackground,
                        fontSize = 12.sp,
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 300, heightDp = 300)
@Composable
private fun Preview() {
    GlanceTheme {
        RandomGameWidgetContentExpanded(
            game = fakeGame
        )
    }
}
package it.fabiocati.thegamedb.widget.randomGame.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.height
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.widget.randomGame.fakeGame

@Composable
internal fun RandomGameWidgetContentCompact(
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
            Text(
                text = game.name,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onBackground
                )
            )
            Spacer(modifier = GlanceModifier.height(2.dp))
            Text(
                text = (game.summary?.take(83) + "..."),
                style = TextStyle(
                    fontSize = 12.sp,
                    color = GlanceTheme.colors.onBackground
                )
            )
        }
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 180, heightDp = 145)
@Composable
private fun Preview() {
    GlanceTheme {
        RandomGameWidgetContentCompact(
            game = fakeGame
        )
    }
}
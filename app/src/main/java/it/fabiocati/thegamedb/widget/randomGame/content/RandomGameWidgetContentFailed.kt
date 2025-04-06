package it.fabiocati.thegamedb.widget.randomGame.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.action.Action
import androidx.glance.action.action
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import it.fabiocati.thegamedb.R

@Composable
internal fun RandomGameWidgetContentFailed(
    onRetryClick: Action = action {  },
) {
    Scaffold(
        titleBar = {
            TitleBar(
                startIcon = ImageProvider(R.drawable.igdb_logo),
                title = "Random Game"
            )
        }
    ) {
        Column(
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = GlanceModifier.fillMaxSize()
        ) {
            Text(
                text = "Unable to retrieve data",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = GlanceTheme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = GlanceModifier.height(12.dp))
            Button(
                text = "Retry",
                onClick = onRetryClick,
            )
        }
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 250, heightDp = 250)
@Composable
private fun Preview() {
    GlanceTheme {
        RandomGameWidgetContentFailed()
    }
}
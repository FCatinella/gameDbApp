package it.fabiocati.thegamedb.widget

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Box
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.text.Text

class GameDBWidgetProvider : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = GameDBWidget()
}

private class GameDBWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Box(
                modifier = GlanceModifier.background(Color.LightGray)
            ) {
                Text(
                    text = "Hello World"
                )
            }
        }
    }
}

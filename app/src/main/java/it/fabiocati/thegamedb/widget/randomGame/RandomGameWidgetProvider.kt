package it.fabiocati.thegamedb.widget.randomGame

import android.content.Context
import androidx.compose.ui.unit.DpSize
import androidx.glance.GlanceId
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.provideContent
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentCompact
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentExpanded
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentMedium

class RandomGameWidgetProvider : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = RandomGameWidget()
}

private class RandomGameWidget : GlanceAppWidget() {
    override val sizeMode: SizeMode = SizeMode.Responsive(
        sizes = RandomGameWidgetSize.entries.map { it.dpSize }.toSet<DpSize>()
    )
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            when (LocalSize.current) {
                RandomGameWidgetSize.COMPACT.dpSize -> RandomGameWidgetContentCompact(fakeGame)
                RandomGameWidgetSize.MEDIUM.dpSize -> RandomGameWidgetContentMedium(fakeGame)
                RandomGameWidgetSize.EXPANDED.dpSize -> RandomGameWidgetContentExpanded(fakeGame)
            }
        }
    }
}
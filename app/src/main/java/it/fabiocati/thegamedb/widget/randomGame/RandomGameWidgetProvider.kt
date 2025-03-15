package it.fabiocati.thegamedb.widget.randomGame

import android.content.Context
import androidx.compose.ui.unit.DpSize
import androidx.glance.GlanceId
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.provideContent
import it.fabiocati.thegamedb.domain.model.PopularityType
import it.fabiocati.thegamedb.domain.usecase.GetGameDetailsUseCase
import it.fabiocati.thegamedb.domain.usecase.GetPopularGamesUseCase
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentCompact
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentExpanded
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentFailed
import it.fabiocati.thegamedb.widget.randomGame.content.RandomGameWidgetContentMedium
import it.fabiocati.thegamedb.widget.randomGame.di.RandomGameKoin

class RandomGameWidgetProvider : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = RandomGameWidget()
}

private class RandomGameWidget : GlanceAppWidget() {
    override val sizeMode: SizeMode = SizeMode.Responsive(
        sizes = setOf(
            RandomGameWidgetSize.COMPACT,
            RandomGameWidgetSize.MEDIUM,
            RandomGameWidgetSize.EXPANDED
        )
    )

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val koin = RandomGameKoin.koin
        runCatching {
            val getPopularGamesUseCase = koin.get<GetPopularGamesUseCase>()
            val getGameDetailsUseCase = koin.get<GetGameDetailsUseCase>()

            val popularGames = getPopularGamesUseCase(popularityType = PopularityType.entries.random())
            val randomGameId = popularGames.random().id

            getGameDetailsUseCase(gameId = randomGameId)
        }.onSuccess { game ->
            provideContent {
                when (LocalSize.current) {
                    RandomGameWidgetSize.COMPACT -> RandomGameWidgetContentCompact(game)
                    RandomGameWidgetSize.MEDIUM -> RandomGameWidgetContentMedium(game)
                    RandomGameWidgetSize.EXPANDED -> RandomGameWidgetContentExpanded(game)
                }
            }
        }.onFailure {
            provideContent {
                RandomGameWidgetContentFailed()
            }
        }
    }
}
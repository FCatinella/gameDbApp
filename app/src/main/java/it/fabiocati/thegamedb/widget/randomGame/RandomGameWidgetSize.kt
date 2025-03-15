package it.fabiocati.thegamedb.widget.randomGame

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

internal enum class RandomGameWidgetSize(
    val dpSize: DpSize,
) {
    COMPACT(DpSize(width = 100.dp, height = 100.dp)),
    MEDIUM(DpSize(width = 300.dp, height = 200.dp)),
    EXPANDED(DpSize(width = 300.dp, height = 300.dp))
}
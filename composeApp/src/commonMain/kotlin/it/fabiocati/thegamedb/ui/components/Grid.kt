package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> Grid(
    items: List<T>,
    columns: Int,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.(T, Int) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        val itemCount = items.count()
        var rows = (items.count() / columns)

        if (itemCount.mod(columns) > 0) {
            rows += 1
        }

        for (rowId in 0 until rows) {
            val firstIndex = rowId * columns

            Row {
                for (columnId in 0 until columns) {
                    val index = firstIndex + columnId
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (index < itemCount) {
                            this@Row.content(items[index], index)
                        }
                    }
                }
            }
        }
    }
}
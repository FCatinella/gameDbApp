package it.fabiocati.thegamedb.utils.extensions

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun WindowInsets.getTopDp(): Dp =
    with(LocalDensity.current) {
        this@getTopDp.getTop(this).toDp()
    }

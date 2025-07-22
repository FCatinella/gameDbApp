package it.fabiocati.thegamedb

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.compositionLocalOf

val LocalWindowWidthSizeClass = compositionLocalOf {
    WindowWidthSizeClass.Compact
}
package it.fabiocati.thegamedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import it.fabiocati.thegamedb.ui.main.TheGameDbApp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val currentWindowWidthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            CompositionLocalProvider(LocalWindowWidthSizeClass provides currentWindowWidthSizeClass) {
                TheGameDbTheme {
                    TheGameDbApp()
                }
            }
        }
    }
}
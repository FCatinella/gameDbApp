package it.fabiocati.thegamedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import it.fabiocati.thegamedb.main.TheGameDbApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val currentWindowWidthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            CompositionLocalProvider(LocalWindowWidthSizeClass provides currentWindowWidthSizeClass) {
                TheGameDbApp()
            }
        }
    }
}
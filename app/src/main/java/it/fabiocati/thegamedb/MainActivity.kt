package it.fabiocati.thegamedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import it.fabiocati.thegamedb.ui.main.TheGameDbApp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TheGameDbTheme {
                TheGameDbApp()
            }
        }
    }
}
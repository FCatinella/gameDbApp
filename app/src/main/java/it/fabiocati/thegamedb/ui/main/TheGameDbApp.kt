package it.fabiocati.thegamedb.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs

@Composable
fun TheGameDbApp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DestinationsNavHost(
            navGraph = NavGraphs.root,
            modifier = Modifier.weight(1f)
        )
    }
}
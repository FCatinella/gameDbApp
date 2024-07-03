package it.fabiocati.thegamedb.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs

@Composable
fun TheGameDbApp() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        DestinationsNavHost(navGraph = NavGraphs.root)
    }
}


@Preview(device = Devices.PIXEL_5)
@Composable
private fun TheGameDbAppPreview() {
    TheGameDbApp()
}
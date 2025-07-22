package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import it.fabiocati.thegamedb.domain.model.MainPlatform
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun PlatformRow(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        PlatformComponent(mainPlatform = MainPlatform.PS5)
        PlatformComponent(mainPlatform = MainPlatform.XBOX_SERIES_X)
        PlatformComponent(mainPlatform = MainPlatform.NINTENDO_SWITCH)
        PlatformComponent(mainPlatform = MainPlatform.PC)
        PlatformComponent(mainPlatform = MainPlatform.OCULUS_VR)
        PlatformComponent(mainPlatform = MainPlatform.ANDROID)
    }
}

@Composable
private fun PlatformSectionPreview() {
    TheGameDbTheme {
        PlatformRow()
    }
}
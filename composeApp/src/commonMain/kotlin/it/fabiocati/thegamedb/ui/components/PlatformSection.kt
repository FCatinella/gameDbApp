package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import it.fabiocati.thegamedb.domain.model.MainPlatform
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun PlatformSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Row {
            PlatformComponent(mainPlatform = MainPlatform.PS5)
            PlatformComponent(mainPlatform = MainPlatform.XBOX_SERIES_X)
            PlatformComponent(mainPlatform = MainPlatform.NINTENDO_SWITCH)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            PlatformComponent(mainPlatform = MainPlatform.PC)
            PlatformComponent(mainPlatform = MainPlatform.OCULUS_VR)
            PlatformComponent(mainPlatform = MainPlatform.ANDROID)
        }
    }
}

@Composable
private fun PlatformSectionPreview() {
    TheGameDbTheme {
        PlatformSection()
    }
}
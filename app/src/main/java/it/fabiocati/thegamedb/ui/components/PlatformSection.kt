package it.fabiocati.thegamedb.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.MainPlatform
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import it.fabiocati.thegamedb.utils.extensions.resourceUri

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

@Preview(device = Devices.PIXEL_5)
@Composable
private fun PlatformSectionPreview() {
    TheGameDbTheme {
        PlatformSection()
    }
}
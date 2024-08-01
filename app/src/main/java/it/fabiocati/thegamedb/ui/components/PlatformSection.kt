package it.fabiocati.thegamedb.ui.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.R
import it.fabiocati.thegamedb.domain.model.Platform
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
            PlatformComponent(platform = Platform.PS5)
            PlatformComponent(platform = Platform.XBOX_SERIES_X)
            PlatformComponent(platform = Platform.NINTENDO_SWITCH)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            PlatformComponent(platform = Platform.PC)
            PlatformComponent(platform = Platform.OCULUS_VR)
            PlatformComponent(platform = Platform.ANDROID)
        }
    }
}


@Composable
fun RowScope.PlatformComponent(
    platform: Platform
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .weight(1f)
            .height(80.dp)
            .padding(6.dp)
            .border(1.dp, MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(6.dp))
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.inversePrimary)
    ) {

        val inverseMatrix = remember {
            ColorMatrix(
                floatArrayOf(
                    -1f, 0f, 0f, 0f, 255f,
                    0f, -1f, 0f, 0f, 255f,
                    0f, 0f, -1f, 0f, 255f,
                    0f, 0f, 0f, 1f, 0f
                )
            )
        }

        val isInDarkMode = LocalConfiguration.current.isNightModeActive

        GameDbImage(
            model = context.resourceUri(platform.getIcon()),
            previewResourceId = platform.getIcon(),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(12.dp),
            colorFilter = if (isInDarkMode) ColorFilter.colorMatrix(inverseMatrix) else null
        )
    }
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun PlatformSectionPreview() {
    TheGameDbTheme {
        PlatformSection()
    }
}


private fun Platform.getIcon(): Int {
    return when (this) {
        Platform.PS5 -> R.drawable.ps5_logo
        Platform.XBOX_SERIES_X -> R.drawable.xbox_series_x_s_logo
        Platform.NINTENDO_SWITCH -> R.drawable.nintendo_switch_logo
        Platform.PC -> R.drawable.pc_logo_png
        Platform.ANDROID -> R.drawable.android_logo
        Platform.OCULUS_VR -> R.drawable.oculus_logo
    }
}
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


@Composable
fun RowScope.PlatformComponent(
    mainPlatform: MainPlatform
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

        val isInDarkMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            LocalConfiguration.current.isNightModeActive
        } else {
            false
        }

        GameDbImage(
            model = context.resourceUri(mainPlatform.getIcon()),
            previewResourceId = mainPlatform.getIcon(),
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


private fun MainPlatform.getIcon(): Int {
    return when (this) {
        MainPlatform.PS5 -> R.drawable.ps5_logo
        MainPlatform.XBOX_SERIES_X -> R.drawable.xbox_series_x_s_logo
        MainPlatform.NINTENDO_SWITCH -> R.drawable.nintendo_switch_logo
        MainPlatform.PC -> R.drawable.pc_logo_png
        MainPlatform.ANDROID -> R.drawable.android_logo
        MainPlatform.OCULUS_VR -> R.drawable.oculus_logo
    }
}
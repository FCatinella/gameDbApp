package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import gamedbapp.composeapp.generated.resources.Res
import gamedbapp.composeapp.generated.resources.android_logo
import gamedbapp.composeapp.generated.resources.nintendo_switch_logo
import gamedbapp.composeapp.generated.resources.oculus_logo
import gamedbapp.composeapp.generated.resources.pc_logo_png
import gamedbapp.composeapp.generated.resources.ps5_logo
import gamedbapp.composeapp.generated.resources.xbox_series_x_s_logo
import it.fabiocati.thegamedb.domain.model.MainPlatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RowScope.PlatformComponent(
    mainPlatform: MainPlatform
) {
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

        val isInDarkMode = isSystemInDarkTheme()

        Image(
            painter = painterResource(mainPlatform.getIcon()),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(12.dp),
            colorFilter = if (isInDarkMode) ColorFilter.colorMatrix(inverseMatrix) else null
        )
    }
}

private fun MainPlatform.getIcon(): DrawableResource {
    return when (this) {
        MainPlatform.PS5 -> Res.drawable.ps5_logo
        MainPlatform.XBOX_SERIES_X -> Res.drawable.xbox_series_x_s_logo
        MainPlatform.NINTENDO_SWITCH -> Res.drawable.nintendo_switch_logo
        MainPlatform.PC -> Res.drawable.pc_logo_png
        MainPlatform.ANDROID -> Res.drawable.android_logo
        MainPlatform.OCULUS_VR -> Res.drawable.oculus_logo
    }
}
package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(100))
            .background(Color.White.copy(alpha = 0.4f))
    ) {
        Icon(
            painter = rememberVectorPainter(image = Icons.AutoMirrored.Rounded.ArrowBack),
            contentDescription = "Back Button"
        )
    }
}


@Preview(device = Devices.PIXEL_5)
@Composable
private fun BackButtonPreview() {
    TheGameDbTheme {
        BackButton()
    }
}
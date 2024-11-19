package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun PlatformBox(
    modifier: Modifier = Modifier,
    text: String = "PS5",
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(25))
            .background(Color.White.copy(alpha = 0.2f))
            .padding(4.dp)
            .padding(horizontal = 2.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(device = Devices.PIXEL_5)
@Composable
private fun AgeRatingBoxPreview() {
    TheGameDbTheme {
        PlatformBox()
    }
}
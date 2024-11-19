package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun SecondaryButton(
    iconVector: ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .padding(horizontal = 2.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = rememberVectorPainter(image = iconVector),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(35.dp),
            contentDescription = ""
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelLarge,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(device = Devices.PIXEL_5)
@Composable
private fun SecondaryButtonPreview() {
    TheGameDbTheme {
        SecondaryButton(
            iconVector = Icons.Default.Movie,
            text = "Trailer",
            onClick = {}
        )
    }
}
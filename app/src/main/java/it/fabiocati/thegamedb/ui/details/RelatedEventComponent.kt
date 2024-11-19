package it.fabiocati.thegamedb.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.Event
import it.fabiocati.thegamedb.ui.components.GameDbImage
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun RelatedEventComponent(
    event: Event,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
    ) {
        GameDbImage(
            model = event.logo,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = event.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = event.description ?: "N/A",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = event.startTime?.let { "${it.dayOfMonth} ${it.month.name} ${it.year}" } ?: "N/A",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

    }
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun RelatedEventComponentPreview() {
    val event = Event(
        id = 6486, name = "Chloe", description = null, logo = null, startTime = null, liveStreamUrl = null
    )
    TheGameDbTheme {
        RelatedEventComponent(
            event = event
        )
    }
}
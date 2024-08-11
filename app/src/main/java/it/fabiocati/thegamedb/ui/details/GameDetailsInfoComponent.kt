package it.fabiocati.thegamedb.ui.details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun GameDetailsInfoComponent(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Red Dead Redemption 2",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed. After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.height(16.dp))
        InfoSection(title = "IGDB ID:", body = "25076")
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(title = "Release Date:", body = "2018-10-26")
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(title = "Genres:", body = "Shooter, Role-playing (RPG), Adventure")
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(title = "Publishers:", body = "Take-two Interactive, Rockstar Games")
    }
}


@Composable
private fun InfoSection(title: String, body: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview(device = Devices.PIXEL_5, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GameDetailsInfoComponentPreview() {
    TheGameDbTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.surfaceVariant)) {
            GameDetailsInfoComponent()
        }
    }
}
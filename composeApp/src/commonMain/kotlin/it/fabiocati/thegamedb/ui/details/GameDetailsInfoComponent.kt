package it.fabiocati.thegamedb.ui.details

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
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.GameDetails
import it.fabiocati.thegamedb.ui.components.LoadingText
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import kotlinx.datetime.LocalDate

@Composable
fun GameDetailsInfoComponent(
    gameDetails: GameDetails?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        LoadingText(
            text = gameDetails?.name,
            placeholderText = "Red Dead Redemption 2",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        LoadingText(
            text = gameDetails?.let { game -> game.storyline ?: "N/A" },
            placeholderText = "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed. After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him.",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        InfoSection(title = "IGDB ID:", body = gameDetails?.id)
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(
            title = "Release Date:",
            body = gameDetails?.let { gameDetails -> gameDetails.dateOfRelease?.toFormattedString() ?: "N/A" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(title = "Genres:", body = "Shooter, Role-playing (RPG), Adventure")
        Spacer(modifier = Modifier.height(8.dp))
        InfoSection(title = "Publishers:", body = "Take-two Interactive, Rockstar Games")
    }
}


@Composable
private fun InfoSection(title: String, body: String?) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        LoadingText(
            text = body,
            placeholderText = "2018-10-09",
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
        )
    }
}

@Composable
private fun GameDetailsInfoComponentPreview() {
    val game = GameDetails(id = "Ikea", name = "Landry", coverUrl = null, screenshotUrls = listOf(), artworkUrls = listOf(), developmentCompany = null, genre = null, dateOfRelease = null, platforms = listOf(), url = null, youtubeUrl = null, storyline = null, summary = null)
    TheGameDbTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.surfaceVariant)) {
            GameDetailsInfoComponent(gameDetails = game)
        }
    }
}

private fun LocalDate.toFormattedString(): String = this.toString()
    //"${String.format("%02d", this.dayOfMonth)}-${String.format("%02d", this.monthNumber)}-${this.year}"
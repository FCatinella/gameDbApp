package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun HomeCoverHorizontalList(
    title: String,
    games: List<Game>,
) {
    Column {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            state = rememberLazyListState()
        ) {
            items(games) { game ->
                GameCover(
                    game = game,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }

}

@Preview
@Composable
private fun HomeCoverHorizontalListPreview() {
    val games = listOf(
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
    )

    TheGameDbTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant)) {
            HomeCoverHorizontalList(
                title = "Games",
                games = games
            )
        }
    }
}
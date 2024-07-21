package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.domain.model.Game

@Composable
fun HomeCoverHorizontalList(
    games: List<Game>,
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
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

@Preview
@Composable
private fun HomeCoverHorizontalListPreview() {
    val games = listOf(
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
        Game(id = "Tommy", name = "Red Dead Redemption 2", coverUrl = null),
    )

    HomeCoverHorizontalList(
        games = games
    )
}
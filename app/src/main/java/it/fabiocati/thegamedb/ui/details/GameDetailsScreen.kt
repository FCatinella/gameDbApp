package it.fabiocati.thegamedb.ui.details

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.ui.components.ActionButton
import it.fabiocati.thegamedb.ui.components.AgeRatingBox
import it.fabiocati.thegamedb.ui.components.BackButton
import it.fabiocati.thegamedb.ui.components.GameDbImage
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme
import it.fabiocati.thegamedb.utils.extensions.getTopDp
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalLayoutApi::class)
@Destination<RootGraph>
@Composable
fun GameDetailsScreen(
    game: Game
) {

    val colorStops = arrayOf(
        0.0f to Color.Transparent,
        0.6f to Color.Transparent,
        1f to MaterialTheme.colorScheme.surfaceVariant
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                GameDbImage(
                    model = game.artworkUrls.lastOrNull(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .drawWithContent {
                            drawContent()
                            drawRect(Brush.verticalGradient(colorStops = colorStops))
                        }
                        .fillMaxWidth()
                        .aspectRatio(1.2f)
                )
            }
            item {
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.headlineLarge.copy(MaterialTheme.colorScheme.onSurfaceVariant),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.6f)
                        .offset(y = (-24).dp)
                )
            }
            item {
                FlowRow(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.offset(y = (-20).dp)
                ) {
                    Text(
                        text = "${game.dateOfRelease?.year ?: "N/A"}",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = game.developmentCompany ?: "",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        textAlign = TextAlign.Center,
                    )
                }
            }
            item {
                val ageRatings = listOf("HD", "Dolby Vision", "5.1", "CC", "AD")
                FlowRow(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.offset(y = (-14).dp)
                ) {
                    ageRatings.forEach {
                        AgeRatingBox(
                            text = it,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
            item {
                ActionButton(
                    text = "Play", onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                )
            }
            item {
                Text(
                    text =
                    """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ac massa ultrices, bibendum augue vitae, pretium nisi. Fusce tempor efficitur dolor a iaculis. 
                    Curabitur at tortor viverra, luctus nibh ut, venenatis quam. Nam interdum augue tellus. 
                    Cras pretium nisl at diam vestibulum, tristique dapibus eros iaculis. 
                    Curabitur eu facilisis nibh. """.trimIndent(),
                    modifier = Modifier.padding(horizontal = 12.dp)

                )
            }
        }
        BackButton(
            modifier = Modifier
                .padding(top = WindowInsets.statusBars.getTopDp())
                .padding(8.dp)
        )
    }
}

@Preview(device = Devices.PIXEL_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun GameDetailsScreenPreview() {
    TheGameDbTheme {
        val game = Game(
            id = "001",
            name = "Red Dead Redemption 2",
            coverUrl = null,
            developmentCompany = "Rockstar games",
            dateOfRelease = LocalDate.fromEpochDays(0)
        )
        GameDetailsScreen(
            game = game
        )
    }
}
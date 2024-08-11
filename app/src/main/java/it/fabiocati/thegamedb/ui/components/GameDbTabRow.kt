package it.fabiocati.thegamedb.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@Composable
fun GameDbTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val prova = listOf("Similar Games", "Events", "Details")

    ScrollableTabRow(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        modifier = modifier.padding(top = 8.dp),
        tabs = {
            prova.forEachIndexed { index, s ->
                val isSelected = index == selectedTabIndex
                Tab(selected = isSelected, onClick = { onTabClick(index) }) {
                    Text(
                        text = s.uppercase(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = if (isSelected) 0.dp else 1.dp)
                            .padding(bottom = 8.dp)
                    )
                }

            }
        },
        indicator = { tabPositions ->
            val selectedTab = tabPositions[selectedTabIndex]
            val tabWidth = selectedTab.contentWidth + 30.dp
            val animatedOffset by animateDpAsState(targetValue = selectedTab.left + (selectedTab.width - tabWidth) / 2)
            val animatedWidth by animateDpAsState(targetValue = tabWidth)

            Box {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .height(4.dp)
                        .width(animatedWidth)
                        .offset(x = animatedOffset)
                        .clip(RoundedCornerShape(topStartPercent = 100, topEndPercent = 100))
                        .background(MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }

        }
    )
}

@Preview(device = Devices.PIXEL_5)
@Composable
private fun GameDbTabRowPreview() {
    TheGameDbTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            GameDbTabRow(
                selectedTabIndex = 1,
                onTabClick = {}
            )
        }
    }
}
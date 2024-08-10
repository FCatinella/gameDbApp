package it.fabiocati.thegamedb.ui.components


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.ui.theme.TheGameDbTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    onAppeared: (() -> Unit)? = null,
) {
    val backgroundColor = MaterialTheme.colorScheme.inversePrimary
    val textColor = MaterialTheme.colorScheme.onSurfaceVariant
    val textAlign = TextAlign.Center
    val shape = RoundedCornerShape(2.dp)

    var selected by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (selected) 0.95f else 1f, label = "scale action button")

    onAppeared?.let { LaunchedEffect(key1 = true) { it() } }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .semantics {
                role = Role.Button
                contentDescription = text
            }
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .scale(scale)
                .fillMaxSize()
                .clip(shape)
                .background(backgroundColor)
                .pointerInput(Unit) {
                    while (true) {
                        awaitPointerEventScope {
                            awaitFirstDown(false)
                            selected = true
                            waitForUpOrCancellation()
                            selected = false
                        }
                    }
                },
        )
        Text(
            text.uppercase(),
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.labelLarge.copy(color = textColor),
            textAlign = textAlign
        )
    }
}

@Composable
@Preview
private fun ActionButtonPreview() {
    TheGameDbTheme {
        ActionButton(text = "Test", onClick = {})
    }
}

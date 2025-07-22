package it.fabiocati.thegamedb.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import it.fabiocati.thegamedb.utils.extensions.shimmerEffect
import kotlin.math.ceil

@Composable
fun LoadingText(
    text: String?,
    placeholderText: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Clip,
    isLoadingPolicy: () -> Boolean = { text == null },
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {

    val columnAlignment = remember(style) {
        when (style.textAlign) {
            TextAlign.Left, TextAlign.Start -> Alignment.Start
            TextAlign.Right, TextAlign.End -> Alignment.End
            TextAlign.Center -> Alignment.CenterHorizontally
            else -> Alignment.Start
        }
    }

    Box(
        modifier = modifier
            .animateContentSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        AnimatedVisibility(
            isLoadingPolicy(),
            exit = fadeOut(
                animationSpec = tween(300, easing = LinearEasing)
            ),
        ) {
            Column(
                horizontalAlignment = columnAlignment
            ) {
                val strings = placeholderText.getLines(fontSize = style.fontSize)
                for (index in strings.indices) {
                    Box(
                        modifier = Modifier
                            .let { if (index != strings.size - 1) it.fillMaxWidth() else it }
                            .let { if (index != strings.size - 1) it.padding(bottom = 8.dp) else it }
                            .clip(RoundedCornerShape(4.dp))
                            .shimmerEffect()
                    ) {
                        Text(
                            text = strings[index],
                            style = style
                                .copy(Color.Transparent),
                            overflow = overflow,
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = !isLoadingPolicy(),
            enter = fadeIn(
                animationSpec = tween(300, easing = LinearEasing)
            ),
        ) {

            Text(
                text = text ?: "",
                style = style,
                minLines = minLines,
                maxLines = maxLines,
                overflow = overflow,
                onTextLayout = onTextLayout,
            )
        }
    }
}

@Composable
fun String.getLines(fontSize: TextUnit): List<String> {
    val lines = with(LocalDensity.current) {
        val pxPerChar = fontSize.toPx() * 1
        val screenWidth = LocalWindowInfo.current.containerSize.width.dp.toPx()
        ceil(screenWidth / pxPerChar).toInt()
    }
    return chunked(lines)
}
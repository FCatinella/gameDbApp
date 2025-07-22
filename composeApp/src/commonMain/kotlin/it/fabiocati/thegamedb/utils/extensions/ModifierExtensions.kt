package it.fabiocati.thegamedb.utils.extensions

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode

fun Modifier.shimmerEffect(show: Boolean = true, color: Color = Color.LightGray) = composed {

    val transition = rememberInfiniteTransition(label = "shimmer")

    val animatedAlpha by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 600),
            repeatMode = RepeatMode.Reverse
        ),
        label = "animatedAlpha",
    )
    val isInPreview = LocalInspectionMode.current
    drawWithContent {
        if (!show || isInPreview) {
            drawContent()
        } else {
            drawRect(color.copy(alpha = animatedAlpha))
        }
    }
}
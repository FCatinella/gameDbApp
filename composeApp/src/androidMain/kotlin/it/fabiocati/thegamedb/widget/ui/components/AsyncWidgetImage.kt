package it.fabiocati.thegamedb.widget.ui.components

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.background
import androidx.glance.layout.ContentScale
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.toBitmap

@Composable
internal fun AsyncWidgetImage(
    data: Any?,
    contentDescription: String?,
    modifier: GlanceModifier = GlanceModifier
) {

    val context = LocalContext.current

    var bitMap: Bitmap? by remember { mutableStateOf(null) }

    LaunchedEffect(data) {
        val request = ImageRequest.Builder(context).data(data).build()
        bitMap = ImageLoader(context).execute(request).image?.toBitmap()
    }

    bitMap?.let {
        Image(
            provider = ImageProvider(it),
            contentScale = ContentScale.Crop,
            contentDescription = contentDescription,
            modifier = modifier.background(GlanceTheme.colors.primary)
        )
    }
}
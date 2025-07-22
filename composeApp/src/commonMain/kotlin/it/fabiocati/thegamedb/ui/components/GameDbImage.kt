package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.decode.DataSource
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import gamedbapp.composeapp.generated.resources.Res
import gamedbapp.composeapp.generated.resources.preview_background_image
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun GameDbImage(
    model: Any?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    isCrossFadeEnable: Boolean = true,
    contentScale: ContentScale = ContentScale.Fit,
    onError: () -> Unit = {},
    onLoading: () -> Unit = {},
    onSuccess: (DataSource) -> Unit = {},
    previewResourceId: DrawableResource = Res.drawable.preview_background_image,
    colorFilter: ColorFilter? = null
) {
    val context = LocalPlatformContext.current

    val imageRequest = remember(model) {
        ImageRequest.Builder(context)
            .data(model)
            .httpHeaders(NetworkHeaders.Builder().set("User-Agent", "Dalvik/").build())
            .crossfade(isCrossFadeEnable)
            .build()
    }
    val imageLoader = remember {
        ImageLoader.Builder(context).build()
    }

    val isInPreview = LocalInspectionMode.current

    val painter = rememberAsyncImagePainter(
        model = imageRequest,
        imageLoader = imageLoader,
        placeholder = if (isInPreview) painterResource(resource = previewResourceId) else null,
        onError = { onError() },
        onLoading = { onLoading() },
        onSuccess = { onSuccess(it.result.dataSource) },
        contentScale = contentScale,
    )

    Image(
        painter = painter,
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        modifier = modifier,
    )
}
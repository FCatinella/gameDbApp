package it.fabiocati.thegamedb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.DataSource
import coil.request.ImageRequest
import it.fabiocati.thegamedb.R
import kotlinx.coroutines.Dispatchers

@Composable
fun GameDbImage(
    model: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    isCrossFadeEnable: Boolean = true,
    contentScale: ContentScale = ContentScale.Fit,
    onError: () -> Unit = {},
    onLoading: () -> Unit = {},
    onSuccess: (DataSource) -> Unit = {},
    previewResourceId: Int = R.drawable.preview_background_image,
) {
    val context = LocalContext.current

    val imageRequest = remember(model) {
        ImageRequest.Builder(context)
            .fetcherDispatcher(Dispatchers.Default)
            .data(model)
            .addHeader("User-Agent", "Dalvik/")
            .crossfade(isCrossFadeEnable)
            .build()
    }
    val imageLoader = remember {
        ImageLoader.Builder(context)
            .bitmapFactoryMaxParallelism(2)
            .respectCacheHeaders(false)
            .build()
    }

    val isInPreview = LocalInspectionMode.current

    val painter = rememberAsyncImagePainter(
        model = imageRequest,
        imageLoader = imageLoader,
        placeholder = if (isInPreview) painterResource(id = previewResourceId) else null,
        onError = { onError() },
        onLoading = { onLoading() },
        onSuccess = { onSuccess(it.result.dataSource) },
        contentScale = contentScale,
    )

    Image(
        painter = painter,
        contentScale = contentScale,
        contentDescription = contentDescription,
        modifier = modifier
    )
}
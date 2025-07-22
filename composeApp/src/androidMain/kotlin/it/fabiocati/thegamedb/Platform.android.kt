package it.fabiocati.thegamedb

import android.os.Build
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val httpClientEngine: HttpClientEngine = OkHttp.create()
}

actual fun getPlatform(): Platform = AndroidPlatform()
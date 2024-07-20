package it.fabiocati.thegamedb.data.network.ktorPlugins

import io.ktor.client.plugins.api.Send
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds


val RateLimitPlugin = createClientPlugin("RateLimitPlugin", ::RateLimitPluginConfig) {
    val timeToWait = pluginConfig.timeToWait

    on(Send) { request ->
        val originalCall = proceed(request)
        val response = originalCall.response
        if (response.status == HttpStatusCode.TooManyRequests) {
            delay(timeToWait)
            return@on proceed(request)
        }
        return@on originalCall
    }
}

class RateLimitPluginConfig {
    var timeToWait: Duration = 1.seconds
}
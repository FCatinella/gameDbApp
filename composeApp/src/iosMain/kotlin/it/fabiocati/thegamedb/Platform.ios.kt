package it.fabiocati.thegamedb

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val httpClientEngine: HttpClientEngine = Darwin.create()
}

actual fun getPlatform(): Platform = IOSPlatform()
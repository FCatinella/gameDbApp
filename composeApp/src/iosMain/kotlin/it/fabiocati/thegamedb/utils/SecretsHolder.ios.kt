package it.fabiocati.thegamedb.utils

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.dictionaryWithContentsOfFile

actual fun getSecrets(): SecretsHolder = iOSSecretsHolder()

private class iOSSecretsHolder() : SecretsHolder {

    private val keys by lazy {
        val path = NSBundle.mainBundle.pathForResource("Info", "plist")
        NSDictionary.dictionaryWithContentsOfFile(path!!)!!
    }

    override val clientId: String = keys["CLIENT_ID"] as String

    override val clientSecret: String = keys["CLIENT_SECRET"] as String

    override val aesKey: String = ""
}



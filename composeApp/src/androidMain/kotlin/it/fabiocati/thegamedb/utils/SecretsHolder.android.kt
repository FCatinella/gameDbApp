package it.fabiocati.thegamedb.utils

import it.fabiocati.thegamedb.BuildConfig

actual fun getSecrets(): SecretsHolder = AndroidSecretsHolder()

private class AndroidSecretsHolder() : SecretsHolder {
    override val clientId: String = BuildConfig.CLIENT_ID
    override val clientSecret: String = BuildConfig.CLIENT_SECRET
    override val aesKey: String = BuildConfig.AES_KEY
}
package it.fabiocati.thegamedb.utils

interface SecretsHolder {
    val clientId: String
    val clientSecret: String

    val aesKey: String
}

expect fun getSecrets(): SecretsHolder
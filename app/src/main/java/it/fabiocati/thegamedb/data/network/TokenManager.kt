package it.fabiocati.thegamedb.data.network

interface TokenManager {
    fun getAccessToken(): String?

    fun saveAccessToken(value: String)
}
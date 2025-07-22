package it.fabiocati.thegamedb.data.network

import it.fabiocati.thegamedb.data.storage.LocalStorage

private const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN"

class TokenManagerImpl(
    private val localStorage: LocalStorage
) : TokenManager {
    override fun getAccessToken(): String? = localStorage.getString(ACCESS_TOKEN_KEY)

    override fun saveAccessToken(value: String) = localStorage.putString(key = ACCESS_TOKEN_KEY, value = value)
}
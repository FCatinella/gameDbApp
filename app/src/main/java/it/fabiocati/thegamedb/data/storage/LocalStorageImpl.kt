package it.fabiocati.thegamedb.data.storage

import android.content.Context
import it.fabiocati.thegamedb.utils.SimpleCipher

private const val LOCAL_STORAGE = "LOCAL_STORAGE"

class LocalStorageImpl(
    context: Context,
    private val cipher: SimpleCipher,
) : LocalStorage {

    private val sharedPreferences = context.getSharedPreferences(LOCAL_STORAGE, Context.MODE_PRIVATE)

    override fun getString(key: String): String? {
        val encryptedString = sharedPreferences.getString(key, null)
        encryptedString ?: return null
        val decryptedString = cipher.decrypt(encryptedString)
        return decryptedString
    }

    override fun putString(key: String, value: String) {
        val encryptedString = cipher.encrypt(value)
        sharedPreferences.edit().putString(key, encryptedString).apply()
    }

    override fun delete(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}
package it.fabiocati.thegamedb.data.storage

interface LocalStorage {
    fun getString(key: String): String?

    fun putString(key: String, value: String)

    fun delete(key: String)
}
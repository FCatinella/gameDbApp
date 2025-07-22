package it.fabiocati.thegamedb.data.storage

import platform.Foundation.NSUserDefaults

class iOSLocalStorage() : LocalStorage {
    override fun getString(key: String): String? =
        NSUserDefaults.standardUserDefaults.stringForKey(key)


    override fun putString(key: String, value: String) =
        NSUserDefaults.standardUserDefaults.setObject(value = value, forKey = key)


    override fun delete(key: String) =
        NSUserDefaults.standardUserDefaults.removeObjectForKey(key)

}
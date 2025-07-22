package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.storage.LocalStorage
import it.fabiocati.thegamedb.data.storage.iOSLocalStorage
import org.koin.core.module.Module
import org.koin.dsl.module

actual val storageModule: Module = module {
    single<LocalStorage> {
        iOSLocalStorage()
    }
}
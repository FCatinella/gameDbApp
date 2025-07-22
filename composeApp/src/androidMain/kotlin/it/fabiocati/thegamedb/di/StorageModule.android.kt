package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.storage.AndroidLocalStorage
import it.fabiocati.thegamedb.data.storage.LocalStorage
import it.fabiocati.thegamedb.utils.SimpleCipher
import org.koin.core.module.Module
import org.koin.dsl.module

actual val storageModule: Module = module {
    single<LocalStorage> { AndroidLocalStorage(context = get(), cipher = get()) }
    single<SimpleCipher> { SimpleCipher() }
}
package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.data.storage.LocalStorage
import it.fabiocati.thegamedb.data.storage.LocalStorageImpl
import it.fabiocati.thegamedb.utils.SimpleCipher
import org.koin.dsl.module

val storageModule = module {
    single<LocalStorage> { LocalStorageImpl(context = get(), cipher = get()) }
    single<SimpleCipher> { SimpleCipher() }
}
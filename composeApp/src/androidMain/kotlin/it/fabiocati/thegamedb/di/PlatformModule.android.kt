package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.AndroidUrlOpener
import it.fabiocati.thegamedb.utils.UrlOpener
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<UrlOpener> { AndroidUrlOpener(context = get()) }
}
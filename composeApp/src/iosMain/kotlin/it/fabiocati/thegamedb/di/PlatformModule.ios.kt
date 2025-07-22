package it.fabiocati.thegamedb.di

import it.fabiocati.thegamedb.utils.UrlOpener
import it.fabiocati.thegamedb.utils.iOSUrlOpener
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<UrlOpener> { iOSUrlOpener() }
}

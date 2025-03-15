package it.fabiocati.thegamedb.widget.randomGame.di

import it.fabiocati.thegamedb.di.networkModule
import it.fabiocati.thegamedb.di.repositoryModule
import it.fabiocati.thegamedb.di.storageModule
import it.fabiocati.thegamedb.di.useCaseModule
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

object RandomGameKoin {

    val koin: Koin by lazy { koinWidgetApplication().koin }

    private fun koinWidgetApplication(): KoinApplication = koinApplication {
        modules(
            listOf(
                networkModule,
                storageModule,
                repositoryModule,
                useCaseModule
            )
        )
    }
}
package it.fabiocati.thegamedb.widget.randomGame.di

import android.content.Context
import it.fabiocati.thegamedb.di.networkModule
import it.fabiocati.thegamedb.di.repositoryModule
import it.fabiocati.thegamedb.di.storageModule
import it.fabiocati.thegamedb.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

internal class RandomGameKoin(
    private val context: Context
) {

    val koin: Koin by lazy { koinWidgetApplication().koin }

    private fun koinWidgetApplication(): KoinApplication = koinApplication {
        androidContext(context)
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
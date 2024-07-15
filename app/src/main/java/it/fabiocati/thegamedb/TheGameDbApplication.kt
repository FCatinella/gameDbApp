package it.fabiocati.thegamedb

import android.app.Application
import it.fabiocati.thegamedb.di.networkModule
import it.fabiocati.thegamedb.di.storageModule
import it.fabiocati.thegamedb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheGameDbApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TheGameDbApplication)
            modules(
                listOf(
                    networkModule,
                    storageModule,
                    viewModelModule
                )
            )
        }
    }
}
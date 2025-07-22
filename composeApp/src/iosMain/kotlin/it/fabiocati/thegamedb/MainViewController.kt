package it.fabiocati.thegamedb

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import it.fabiocati.thegamedb.di.networkModule
import it.fabiocati.thegamedb.di.platformModule
import it.fabiocati.thegamedb.di.repositoryModule
import it.fabiocati.thegamedb.di.storageModule
import it.fabiocati.thegamedb.di.useCaseModule
import it.fabiocati.thegamedb.di.viewModelModule
import it.fabiocati.thegamedb.main.TheGameDbApp
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun MainViewController(): UIViewController {
    startKoin {
        modules(
            listOf(
                platformModule,
                networkModule,
                storageModule,
                viewModelModule,
                repositoryModule,
                useCaseModule
            )
        )
    }

    return ComposeUIViewController {
        val currentWindowWidthSizeClass = calculateWindowSizeClass().widthSizeClass
        CompositionLocalProvider(LocalWindowWidthSizeClass provides currentWindowWidthSizeClass) {
            TheGameDbApp()
        }
    }
}
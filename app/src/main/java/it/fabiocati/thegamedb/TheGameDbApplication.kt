package it.fabiocati.thegamedb

import android.app.Application
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.os.Build
import androidx.glance.appwidget.compose
import it.fabiocati.thegamedb.di.networkModule
import it.fabiocati.thegamedb.di.repositoryModule
import it.fabiocati.thegamedb.di.storageModule
import it.fabiocati.thegamedb.di.useCaseModule
import it.fabiocati.thegamedb.di.viewModelModule
import it.fabiocati.thegamedb.widget.randomGame.RandomGameWidgetProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheGameDbApplication : Application() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TheGameDbApplication)
            modules(
                listOf(
                    networkModule,
                    storageModule,
                    viewModelModule,
                    repositoryModule,
                    useCaseModule
                )
            )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            coroutineScope.launch {
                val provider = ComponentName(this@TheGameDbApplication, RandomGameWidgetProvider::class.java)
                val widgetPreview = RandomGameWidgetProvider().preview.compose(
                    context = this@TheGameDbApplication
                )
                AppWidgetManager.getInstance(this@TheGameDbApplication).setWidgetPreview(
                    provider,
                    AppWidgetProviderInfo.WIDGET_CATEGORY_HOME_SCREEN,
                    widgetPreview
                )
            }
        }
    }
}
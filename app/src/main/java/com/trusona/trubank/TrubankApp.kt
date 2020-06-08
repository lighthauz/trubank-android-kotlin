package com.trusona.trubank

import android.app.Application
import com.trusona.trubank.di.DependencyModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class TrubankApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TrubankApp)
            modules(DependencyModuleProvider.modules)
        }

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
package com.trusona.trubank

import android.app.Application
import timber.log.Timber

class TrubankApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
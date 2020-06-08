package com.trusona.trubank.di

import android.content.ContentResolver
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object DependencyModuleProvider {

    private val appModule = module {
        single<ContentResolver> {
            androidContext().contentResolver
        }
    }

    val modules: List<Module>
    get() {
        return ArrayList<Module>().apply {
            add(appModule)
            addAll(DataSourceModules.modules)
        }
    }
}
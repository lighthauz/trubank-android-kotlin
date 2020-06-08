package com.trusona.trubank.di

import com.trusona.trubank.http.datasource.RegistrationDataSource
import com.trusona.trubank.http.datasource.SessionDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

object DataSourceModules : BaseModuleProvider {

    override val modules: List<Module>
        get() = listOf(registrationDataSourceModule, sessionDataSourceModule)

    private val registrationDataSourceModule = module {
        single { RegistrationDataSource(get()) }
    }

    private val sessionDataSourceModule = module {
        single { SessionDataSource(get()) }
    }
}
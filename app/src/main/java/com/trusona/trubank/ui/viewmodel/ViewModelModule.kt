package com.trusona.trubank.ui.viewmodel

import com.trusona.trubank.di.BaseViewModelModuleProvider
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object ViewModelModule : BaseViewModelModuleProvider {
    override fun loadModules() = lazyLoadModule

    private val lazyLoadModule by lazy {
        loadKoinModules(
            listOf(registrationViewModelModule, sessionViewModelModule)
        )
    }
    private val registrationViewModelModule = module {
        viewModel {
            RegistrationViewModel(get())
        }
    }
    private val sessionViewModelModule = module {
        viewModel {
            SessionViewModel(get())
        }
    }
}
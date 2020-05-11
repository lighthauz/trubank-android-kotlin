package com.trusona.trubank.di

import org.koin.core.module.Module

interface BaseModuleProvider {

    val modules: List<Module>
}
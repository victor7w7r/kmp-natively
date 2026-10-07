package com.victor7w7r.kmpNatively.core.di

import org.koin.dsl.module
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.core.Koin

val appModule = module {
    // Aquí puedes declarar tus single/factory, ejemplo:
    // single { MiRepositorio(get()) }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}): Koin {
    return startKoin {
        appDeclaration()
        modules(appModule)
    }.koin
}

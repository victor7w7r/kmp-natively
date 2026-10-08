package com.victor7w7r.kmpNatively.core.di

import com.victor7w7r.kmpNatively.features.common.CommonModule
import org.koin.core.annotation.*
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.plugin.module.dsl.startKoin

@Module(includes = [CommonModule::class])
@ComponentScan("com.victor7w7r.kmpNatively")
@Configuration
class AppModule

@KoinApplication
object KoinApp

fun initKoin(config: KoinAppDeclaration? = null) {
  startKoin<KoinApp> {
    includes(config)
  }
}

@Suppress("UNUSED_PARAMETER")
fun initKoinIos() = initKoin()

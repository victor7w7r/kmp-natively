package com.victor7w7r.kmpNatively.core.modules

import com.victor7w7r.kmpNatively.core.constants.Constants
import com.victor7w7r.kmpNatively.features.common.data.datasources.BinanceRemoteDataSource
import com.victor7w7r.kmpNatively.features.common.data.datasources.createBinanceRemoteDataSource
import de.jensklingenberg.ktorfit.Ktorfit
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.SingleIn
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

@BindingContainer
object HttpModule {
  @Provides
  fun httpClient(): HttpClient = HttpClient { install(ContentNegotiation) { json() } }

  @Provides
  @SingleIn(AppScope::class)
  fun ktorfitClient(client: HttpClient): Ktorfit =
    Ktorfit
      .Builder()
      .baseUrl(Constants.HOST)
      .httpClient(client)
      .build()

  @Provides
  fun provideBinanceRemoteDataSource(ktorfit: Ktorfit): BinanceRemoteDataSource = ktorfit.createBinanceRemoteDataSource()
}

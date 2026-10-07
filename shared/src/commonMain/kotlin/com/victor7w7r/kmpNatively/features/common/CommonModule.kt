package com.victor7w7r.kmpNatively.features.common

import com.victor7w7r.kmpNatively.core.constants.Constants
import com.victor7w7r.kmpNatively.features.common.data.datasources.BinanceRemoteDataSource
import com.victor7w7r.kmpNatively.features.common.data.datasources.createBinanceRemoteDataSource
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class CommonModule {
  @Single
  fun httpClient() =
    HttpClient {
      install(ContentNegotiation) {
        json()
      }
    }

  @Single
  fun ktorfitClient(client: HttpClient) =
    Ktorfit
      .Builder()
      .baseUrl(Constants.host)
      .httpClient(client)
      .build()

  @Single
  fun provideBinanceRemoteDataSource(ktorfit: Ktorfit): BinanceRemoteDataSource = ktorfit.createBinanceRemoteDataSource()
}

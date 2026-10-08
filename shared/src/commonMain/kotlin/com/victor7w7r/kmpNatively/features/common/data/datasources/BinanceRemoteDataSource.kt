package com.victor7w7r.kmpNatively.features.common.data.datasources

import de.jensklingenberg.ktorfit.http.*

interface BinanceRemoteDataSource {
  @GET("/ticker/price?symbol=BTCUSD")
  suspend fun getBitcoin(): String
}

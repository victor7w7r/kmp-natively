package com.victor7w7r.kmpNatively.features.common.data.datasources

import com.victor7w7r.kmpNatively.features.common.data.dto.BinanceDto
import de.jensklingenberg.ktorfit.http.*

interface BinanceRemoteDataSource {
  @GET("/ticker/price?symbol=BTCUSD")
  suspend fun getCurrencies(): List<BinanceDto>
}

package com.victor7w7r.kmpNatively.features.common.business.repositories

import com.victor7w7r.kmpNatively.features.common.business.entities.Binance
import com.victor7w7r.kmpNatively.features.common.business.entities.Bitcoin

interface BinanceRepository {
  suspend fun getBitcoin(symbol: String): Bitcoin?

  suspend fun getAllBinance(symbol: String): List<Binance>
}

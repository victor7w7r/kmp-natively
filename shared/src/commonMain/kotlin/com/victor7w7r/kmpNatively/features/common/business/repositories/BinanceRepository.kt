package com.victor7w7r.kmpNatively.features.common.business.repositories

import arrow.core.Either
import arrow.core.Option
import com.victor7w7r.kmpNatively.features.common.business.entities.Binance
import kotlinx.coroutines.flow.Flow

typealias BinanceResult = Option<Either<String, List<Binance>>>

fun interface BinanceRepository {
  fun getAllCurrencies(): Flow<BinanceResult>
}

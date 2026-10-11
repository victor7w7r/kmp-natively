package com.victor7w7r.kmpNatively.features.common.business.repositories

import arrow.core.Either
import arrow.core.Option
import com.victor7w7r.kmpNatively.features.common.business.entities.Coins
import kotlinx.coroutines.flow.Flow

typealias CoinsResult = Option<Either<String, List<Coins>>>

fun interface CoinsRepository {
  fun getAllCurrencies(): Flow<CoinsResult>
}

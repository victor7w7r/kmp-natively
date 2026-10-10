package com.victor7w7r.kmpNatively.features.common.data.repositories

import arrow.core.Either
import arrow.core.none
import arrow.core.some
import com.victor7w7r.kmpNatively.features.common.business.entities.Binance
import com.victor7w7r.kmpNatively.features.common.business.repositories.BinanceRepository
import com.victor7w7r.kmpNatively.features.common.data.datasources.BinanceRemoteDataSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Factory

@Factory
class BinanceRepositoryImpl(
  private val remoteDataSource: BinanceRemoteDataSource,
) : BinanceRepository {
  override fun getAllCurrencies() =
    flow {
      emit(none())
      emit(
        Either
          .catch {
            remoteDataSource.getCurrencies().map { Binance(it.price, it.symbol) }
          }.mapLeft { it.message ?: "An error occurred" }
          .some(),
      )
    }.catch { throwable ->
      emit(Either.Left(throwable.message ?: "An error occurred").some())
    }
}

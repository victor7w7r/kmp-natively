package com.victor7w7r.kmpNatively.features.common.data.repositories

import arrow.core.Either
import arrow.core.none
import arrow.core.some
import com.victor7w7r.kmpNatively.core.utils.formatFiat
import com.victor7w7r.kmpNatively.core.utils.formatPercentage
import com.victor7w7r.kmpNatively.features.common.business.entities.Coins
import com.victor7w7r.kmpNatively.features.common.business.repositories.CoinsRepository
import com.victor7w7r.kmpNatively.features.common.data.datasources.CoinsRemoteDataSource
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

@ContributesBinding(AppScope::class)
@Inject
class CoinsRepositoryImpl(
  private val remoteDataSource: CoinsRemoteDataSource,
) : CoinsRepository {
  override fun getAllCurrencies() =
    flow {
      emit(none())
      emit(
        Either
          .catch {
            remoteDataSource.getCurrencies().map {
              Coins(
                it.iconUrl,
                it.name,
                it.symbol,
                formatFiat(it.price),
                formatPercentage(it.change),
                it.change >= 0,
              )
            }
          }.mapLeft { it.message ?: "An error occurred" }
          .some(),
      )
    }.catch { throwable ->
      emit(Either.Left(throwable.message ?: "An error occurred").some())
    }
}

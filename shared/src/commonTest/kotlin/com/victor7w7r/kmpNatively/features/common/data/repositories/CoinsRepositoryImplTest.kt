package com.victor7w7r.kmpNatively.features.common.data.repositories

import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import com.victor7w7r.kmpNatively.core.utils.formatFiat
import com.victor7w7r.kmpNatively.core.utils.formatPercentage
import com.victor7w7r.kmpNatively.features.common.business.entities.Coins
import com.victor7w7r.kmpNatively.features.common.data.datasources.CoinsRemoteDataSource
import com.victor7w7r.kmpNatively.features.common.data.dto.CoinsDto
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CoinsRepositoryImplTest {
  @Test
  fun emitsLoadingThenFormattedCurrencies() =
    runTest {
      val source =
        FakeCoinsRemoteDataSource {
          listOf(
            CoinsDto("BTC", "Bitcoin", "btc.png", 1234.5, 2.5),
            CoinsDto("ETH", "Ethereum", "eth.png", 2500.0, -1.25),
            CoinsDto("ZERO", "Zero", "zero.png", 0.0, 0.0),
          )
        }

      val results = CoinsRepositoryImpl(source).getAllCurrencies().toList()
      val expectedCoins =
        listOf(
          Coins("btc.png", "Bitcoin", "BTC", formatFiat(1234.5), formatPercentage(2.5), true),
          Coins("eth.png", "Ethereum", "ETH", formatFiat(2500.0), formatPercentage(-1.25), false),
          Coins("zero.png", "Zero", "ZERO", formatFiat(0.0), formatPercentage(0.0), true),
        )

      assertEquals(listOf(None, Some(Either.Right(expectedCoins))), results)
    }

  @Test
  fun emitsAnEmptyCurrencyListWhenTheSourceReturnsNoCurrencies() =
    runTest {
      val results = CoinsRepositoryImpl(FakeCoinsRemoteDataSource { emptyList() }).getAllCurrencies().toList()

      assertEquals(listOf(None, Some(Either.Right(emptyList()))), results)
    }

  @Test
  fun emitsTheRemoteErrorAfterTheLoadingState() =
    runTest {
      val results =
        CoinsRepositoryImpl(
          FakeCoinsRemoteDataSource { throw IllegalStateException("Network unavailable") },
        ).getAllCurrencies().toList()

      assertEquals(listOf(None, Some(Either.Left("Network unavailable"))), results)
    }

  @Test
  fun usesAFallbackMessageWhenTheRemoteErrorHasNoMessage() =
    runTest {
      val results =
        CoinsRepositoryImpl(
          FakeCoinsRemoteDataSource { throw IllegalStateException() },
        ).getAllCurrencies().toList()

      assertEquals(listOf(None, Some(Either.Left("An error occurred"))), results)
    }

  private class FakeCoinsRemoteDataSource(
    private val response: () -> List<CoinsDto>,
  ) : CoinsRemoteDataSource {
    override suspend fun getCurrencies(): List<CoinsDto> = response()
  }
}

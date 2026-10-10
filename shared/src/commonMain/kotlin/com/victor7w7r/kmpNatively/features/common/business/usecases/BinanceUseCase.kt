package com.victor7w7r.kmpNatively.features.common.business.usecases

import com.victor7w7r.kmpNatively.core.interfaces.UseCase
import com.victor7w7r.kmpNatively.features.common.business.entities.Binance
import com.victor7w7r.kmpNatively.features.common.business.repositories.BinanceRepository
import org.koin.core.annotation.Factory

@Factory
class BinanceUseCase(
  private val binanceRepository: BinanceRepository,
) : UseCase<String, List<Binance>> {
  override fun invoke() = binanceRepository.getAllCurrencies()
}

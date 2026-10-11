package com.victor7w7r.kmpNatively.features.common.business.usecases

import com.victor7w7r.kmpNatively.core.interfaces.FlowEitherUseCase
import com.victor7w7r.kmpNatively.features.common.business.entities.Binance
import com.victor7w7r.kmpNatively.features.common.business.repositories.BinanceRepository
import dev.zacsweers.metro.Inject

@Inject
class BinanceUseCase(
  private val binanceRepository: BinanceRepository,
) : FlowEitherUseCase<String, List<Binance>> {
  override fun invoke() = binanceRepository.getAllCurrencies()
}

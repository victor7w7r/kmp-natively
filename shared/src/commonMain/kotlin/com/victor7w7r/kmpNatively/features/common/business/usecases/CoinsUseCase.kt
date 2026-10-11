package com.victor7w7r.kmpNatively.features.common.business.usecases

import com.victor7w7r.kmpNatively.core.interfaces.FlowUseCase
import com.victor7w7r.kmpNatively.features.common.business.repositories.CoinsRepository
import com.victor7w7r.kmpNatively.features.common.business.repositories.CoinsResult
import dev.zacsweers.metro.Inject

@Inject class CoinsUseCase(
  private val coinsRepository: CoinsRepository,
) : FlowUseCase<CoinsResult> {
  override fun invoke() = coinsRepository.getAllCurrencies()
}

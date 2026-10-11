package com.victor7w7r.kmpNatively.features.common.business.usecases

import com.victor7w7r.kmpNatively.core.interfaces.SingleUseCase
import com.victor7w7r.kmpNatively.features.common.business.repositories.ThemeRepository
import dev.zacsweers.metro.Inject

@Inject
class GetThemeUseCase(
  private val themeRepository: ThemeRepository,
) : SingleUseCase<Boolean> {
  override fun invoke() = themeRepository.isDarkMode
}

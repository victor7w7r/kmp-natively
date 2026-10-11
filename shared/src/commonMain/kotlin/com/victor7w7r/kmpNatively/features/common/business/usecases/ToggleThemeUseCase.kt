package com.victor7w7r.kmpNatively.features.common.business.usecases

import com.victor7w7r.kmpNatively.core.interfaces.SingleUseCase
import com.victor7w7r.kmpNatively.features.common.business.repositories.ThemeRepository
import dev.zacsweers.metro.Inject

@Inject
class ToggleThemeUseCase(
  private val themeRepository: ThemeRepository,
) : SingleUseCase<Unit> {
  override fun invoke() = themeRepository.toggleTheme()
}

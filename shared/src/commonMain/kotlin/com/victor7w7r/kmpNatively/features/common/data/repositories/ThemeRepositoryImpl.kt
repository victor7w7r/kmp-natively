package com.victor7w7r.kmpNatively.features.common.data.repositories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.victor7w7r.kmpNatively.features.common.business.repositories.ThemeRepository
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn

@ContributesBinding(AppScope::class)
@SingleIn(AppScope::class)
@Inject
class ThemeRepositoryImpl : ThemeRepository {
  override var isDarkMode by mutableStateOf(true)
    private set

  override fun toggleTheme() {
    isDarkMode = !isDarkMode
  }
}

package com.victor7w7r.kmpNatively.features.common.business.repositories

import androidx.compose.runtime.MutableState

interface ThemeRepository {
  val isDarkMode: Boolean

  fun toggleTheme()
}

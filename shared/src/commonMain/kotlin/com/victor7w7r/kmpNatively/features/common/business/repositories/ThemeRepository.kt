package com.victor7w7r.kmpNatively.features.common.business.repositories

interface ThemeRepository {
  val isDarkMode: Boolean

  fun toggleTheme()
}

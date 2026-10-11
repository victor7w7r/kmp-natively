package com.victor7w7r.kmpNatively.core.resources.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
  var isDark by mutableStateOf(true)
    private set

  fun toggleTheme() {
    isDark = !isDark
  }

  fun setTheme(dark: Boolean) {
    isDark = dark
  }
}

internal val LocalThemeViewModel =
  staticCompositionLocalOf<ThemeViewModel> {
    error("No AppThemeViewModel provided")
  }

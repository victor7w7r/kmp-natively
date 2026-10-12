package com.victor7w7r.kmpNatively

import androidx.compose.runtime.*
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.victor7w7r.kmpNatively.core.resources.AppTheme
import com.victor7w7r.kmpNatively.features.common.business.usecases.GetThemeUseCase
import com.victor7w7r.kmpNatively.features.common.business.usecases.ToggleThemeUseCase
import com.victor7w7r.kmpNatively.features.common.ui.layout.Layout
import dev.zacsweers.metro.Inject

@Inject class AppClass(
  private val circuit: Circuit,
  private val getThemeUseCase: GetThemeUseCase,
  private val toggleThemeUseCase: ToggleThemeUseCase,
) {
  @Composable operator fun invoke() = App(circuit, getThemeUseCase()) { toggleThemeUseCase.invoke() }
}

@Suppress("ktlint:compose:modifier-missing-check")
@Composable
fun App(
  circuit: Circuit,
  isDarkMode: Boolean,
  toggleTheme: () -> Unit,
) = CircuitCompositionLocals(circuit) {
  // val backStack = rememberSaveableBackStack(root = HomeScreen)
  // val navigator = rememberCircuitNavigator(backStack) {}

  AppTheme(isDarkMode = isDarkMode) {
    Layout(isDarkMode = isDarkMode, toggleTheme = toggleTheme) {
      // NavigableCircuitContent(navigator, backStack)
    }
  }
}

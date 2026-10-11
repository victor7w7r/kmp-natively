package com.victor7w7r.kmpNatively

import androidx.compose.runtime.*
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.victor7w7r.kmpNatively.core.resources.theme.AppTheme
import com.victor7w7r.kmpNatively.features.common.ui.layout.Layout
import com.victor7w7r.kmpNatively.features.common.ui.pages.home.HomeScreen
import dev.zacsweers.metro.Inject

@Inject
class AppClass(
  private val circuit: Circuit,
) {
  @Composable
  operator fun invoke() = App(circuit)
}

@Suppress("ktlint:compose:modifier-missing-check")
@Composable
fun App(circuit: Circuit) =
  AppTheme {
    CircuitCompositionLocals(circuit) {
      val backStack = rememberSaveableBackStack(root = HomeScreen)
      val navigator = rememberCircuitNavigator(backStack) {}

      Layout(navigator = navigator) {
        NavigableCircuitContent(navigator, backStack)
      }
    }
  }

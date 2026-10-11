package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.victor7w7r.kmpNatively.features.common.ui.pages.home.HomeScreen
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@CircuitInject(StoreScreen::class, AppScope::class)
@Inject
class StorePresenter(
  private val navigator: Navigator,
) : Presenter<StoreScreen.State> {
  @Composable
  override fun present() =
    StoreScreen.State { event ->
      when (event) {
        else -> {}
      }
    }

  class Factory : Presenter.Factory {
    override fun create(
      screen: Screen,
      navigator: Navigator,
      context: CircuitContext,
    ): Presenter<*>? =
      when (screen) {
        is StoreScreen -> StorePresenter(navigator = navigator)
        else -> null
      }
  }
}

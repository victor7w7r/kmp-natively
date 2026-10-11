package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@CircuitInject(HomeScreen::class, AppScope::class)
@Inject
class HomePresenter(
  private val navigator: Navigator,
) : Presenter<HomeScreen.State> {
  @Composable
  override fun present() =
    HomeScreen.State { event ->
      when (event) {
        HomeScreen.Event.NavigateBarButtonClicked -> {}
      }
    }

  class Factory : Presenter.Factory {
    override fun create(
      screen: Screen,
      navigator: Navigator,
      context: CircuitContext,
    ): Presenter<*>? =
      when (screen) {
        is HomeScreen -> HomePresenter(navigator = navigator)
        else -> null
      }
  }
}

package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.serialization.CircuitSerializable
import com.victor7w7r.kmpNatively.features.common.business.usecases.ToggleThemeUseCase
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@CircuitSerializable(AppScope::class)
data object HomeScreen : Screen {
  data class State(
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  sealed class Event : CircuitUiEvent {
    data object ToggleDarkMode : Event()
  }
}

@CircuitInject(HomeScreen::class, AppScope::class)
@Inject
class HomePresenter(
  private val toggleThemeUseCase: ToggleThemeUseCase,
  private val navigator: Navigator,
) : Presenter<HomeScreen.State> {
  @Composable
  override fun present() =
    HomeScreen.State { event ->
      when (event) {
        HomeScreen.Event.ToggleDarkMode -> toggleThemeUseCase()
      }
    }
}

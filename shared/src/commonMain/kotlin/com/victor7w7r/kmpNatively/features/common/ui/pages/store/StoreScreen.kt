package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

data object StoreScreen : Screen {
  data class State(
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  sealed class Event : CircuitUiEvent
}

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
}

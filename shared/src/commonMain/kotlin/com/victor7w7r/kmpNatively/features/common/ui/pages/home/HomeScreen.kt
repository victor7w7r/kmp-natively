package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.serialization.CircuitSerializable
import dev.zacsweers.metro.AppScope

@CircuitSerializable(AppScope::class)
data object HomeScreen : Screen {
  data class State(
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  sealed class Event : CircuitUiEvent {
    data object NavigateBarButtonClicked : Event()
  }
}

package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.serialization.CircuitSerializable
import com.victor7w7r.kmpNatively.features.common.ui.services.StoreService
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@CircuitSerializable(AppScope::class)
data object StoreScreen : Screen {
  data class State(
    val text: String,
    val savedText: String,
    val showDialog: Boolean,
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  sealed class Event : CircuitUiEvent {
    data class OnTextChanged(
      val text: String,
    ) : Event()

    data class SubmitText(
      val text: String,
    ) : Event()

    data object DismissErrorDialog : Event()
  }
}

@CircuitInject(StoreScreen::class, AppScope::class)
@Inject
class StorePresenter(
  private val storeService: StoreService,
) : Presenter<StoreScreen.State> {
  @Composable
  override fun present(): StoreScreen.State {
    var textInput by remember { mutableStateOf(storeService.storeState) }
    var savedText by remember { mutableStateOf(storeService.storeState) }
    var showDialog by remember { mutableStateOf(false) }

    return StoreScreen.State(
      text = textInput,
      savedText = savedText,
      showDialog = showDialog,
      eventSink = { event ->
        when (event) {
          is StoreScreen.Event.OnTextChanged -> {
            textInput = event.text
          }

          is StoreScreen.Event.SubmitText -> {
            if (event.text.isBlank()) {
              showDialog = true
            } else {
              storeService.setState(event.text)
              savedText = event.text
            }
          }

          is StoreScreen.Event.DismissErrorDialog -> {
            showDialog = false
          }
        }
      },
    )
  }
}

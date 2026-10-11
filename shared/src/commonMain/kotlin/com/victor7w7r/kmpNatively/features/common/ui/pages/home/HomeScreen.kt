package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import arrow.core.None
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.produceRetainedState
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.serialization.CircuitSerializable
import com.victor7w7r.kmpNatively.features.common.business.repositories.CoinsResult
import com.victor7w7r.kmpNatively.features.common.business.usecases.CoinsUseCase
import com.victor7w7r.kmpNatively.features.common.business.usecases.GetThemeUseCase
import com.victor7w7r.kmpNatively.features.common.ui.pages.home.HomeScreen.State
import com.victor7w7r.kmpNatively.features.common.ui.services.StoreService
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@CircuitSerializable(AppScope::class)
data object HomeScreen : Screen {
  data class State(
    val isDarkMode: Boolean,
    val storeText: String,
    val coinsState: CoinsResult,
    val isRefreshing: Boolean,
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  sealed class Event : CircuitUiEvent {
    data object OnRefresh : Event()
  }
}

@CircuitInject(HomeScreen::class, AppScope::class)
@Inject
class HomePresenter(
  private val getThemeUseCase: GetThemeUseCase,
  private val coinsUseCase: CoinsUseCase,
  private val storeService: StoreService,
) : Presenter<State> {
  @Composable
  override fun present(): State {
    val storeText by remember { mutableStateOf(storeService.storeState) }
    var refreshKey by rememberRetained { mutableIntStateOf(0) }
    var isRefreshing by rememberRetained { mutableStateOf(false) }

    val coinsState by produceRetainedState<CoinsResult>(None, refreshKey) {
      coinsUseCase().collect { latest ->
        value = latest
        isRefreshing = false
      }
    }

    return State(
      isDarkMode = getThemeUseCase(),
      storeText = storeText,
      coinsState = coinsState,
      isRefreshing = isRefreshing,
      eventSink = { event ->
        when (event) {
          is HomeScreen.Event.OnRefresh -> {
            refreshKey++
          }
        }
      },
    )
  }
}

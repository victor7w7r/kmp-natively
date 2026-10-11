package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dev.zacsweers.metro.AppScope

@CircuitInject(StoreScreen::class, AppScope::class)
@Composable
fun Store(
  state: StoreScreen.State,
  modifier: Modifier = Modifier,
) {
  Text(text = "test")
}

package com.victor7w7r.kmpNatively

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.victor7w7r.kmpNatively.core.modules.AppGraph
import dev.zacsweers.metro.createGraph

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  try {
    val app = createGraph<AppGraph>().app
    ComposeViewport { app() }
  } catch (ex: Throwable) {
    ex.printStackTrace()
    throw ex
  }
}

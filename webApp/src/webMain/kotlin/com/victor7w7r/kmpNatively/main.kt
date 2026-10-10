package com.victor7w7r.kmpNatively

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  initNavigationRegistry()
  ComposeViewport { App() }
}

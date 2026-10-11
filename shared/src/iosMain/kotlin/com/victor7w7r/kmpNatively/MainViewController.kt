package com.victor7w7r.kmpNatively

import androidx.compose.ui.window.ComposeUIViewController
import com.victor7w7r.kmpNatively.core.modules.AppGraph
import dev.zacsweers.metro.createGraph
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
  val app = createGraph<AppGraph>().app
  return ComposeUIViewController { app() }
}

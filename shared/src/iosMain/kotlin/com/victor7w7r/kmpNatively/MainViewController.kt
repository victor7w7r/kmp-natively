package com.victor7w7r.kmpNatively

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.UIViewController
import platform.UIKit.setStatusBarStyle

fun MinViewController(): UIViewController =
  ComposeUIViewController {
    initNavigationRegistry()
    App(onThemeChange = { ThemeChanged(it) })
  }

@Composable
private fun ThemeChanged(isDark: Boolean) {
  LaunchedEffect(isDark) {
    UIApplication.sharedApplication.setStatusBarStyle(
      if (isDark) UIStatusBarStyleDarkContent else UIStatusBarStyleLightContent,
    )
  }
}

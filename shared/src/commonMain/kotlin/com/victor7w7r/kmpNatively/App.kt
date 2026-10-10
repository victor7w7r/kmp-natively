package com.victor7w7r.kmpNatively

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.victor7w7r.kmpNatively.core.di.KoinApp
import com.victor7w7r.kmpNatively.features.common.ui.layout.Layout
import com.victor7w7r.kmpNatively.features.common.ui.navigation.CommonNavigationProvider
import com.victor7w7r.kmpNatively.features.common.ui.navigation.commonNavigationModule
import org.koin.compose.KoinApplication
import org.koin.plugin.module.dsl.koinConfiguration

fun initNavigationRegistry() =
  ScreenRegistry {
    commonNavigationModule()
  }

@Preview
@Composable
fun App() =
  KoinApplication(configuration = koinConfiguration<KoinApp>()) {
    Layout {
      val initialScreen = rememberScreen(CommonNavigationProvider.HomePage)
      Navigator(screen = initialScreen)
    }
  }

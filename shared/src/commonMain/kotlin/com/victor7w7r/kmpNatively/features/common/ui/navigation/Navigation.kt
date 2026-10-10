package com.victor7w7r.kmpNatively.features.common.ui.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.screenModule
import com.victor7w7r.kmpNatively.features.common.ui.pages.home.HomePage
import com.victor7w7r.kmpNatively.features.common.ui.pages.store.StorePage

sealed class CommonNavigationProvider : ScreenProvider {
  data object HomePage : CommonNavigationProvider()

  data object StorePage : CommonNavigationProvider()
}

val commonNavigationModule =
  screenModule {
    register<CommonNavigationProvider.HomePage> { HomePage() }
    register<CommonNavigationProvider.StorePage> { StorePage() }
  }

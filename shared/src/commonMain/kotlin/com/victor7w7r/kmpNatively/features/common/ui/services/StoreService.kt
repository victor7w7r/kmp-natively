package com.victor7w7r.kmpNatively.features.common.ui.services

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn

@SingleIn(AppScope::class)
@Inject
class StoreService {
  var storeState = ""
    private set

  fun setState(newState: String) {
    storeState = newState
  }
}

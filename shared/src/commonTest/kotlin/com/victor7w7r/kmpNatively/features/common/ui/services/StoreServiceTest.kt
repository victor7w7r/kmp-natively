package com.victor7w7r.kmpNatively.features.common.ui.services

import kotlin.test.Test
import kotlin.test.assertEquals

class StoreServiceTest {
  @Test
  fun startsWithAnEmptyState() {
    assertEquals("", StoreService().storeState)
  }

  @Test
  fun storesTheLatestState() {
    val service = StoreService()

    service.setState("first")
    assertEquals("first", service.storeState)

    service.setState("updated")
    assertEquals("updated", service.storeState)
  }
}

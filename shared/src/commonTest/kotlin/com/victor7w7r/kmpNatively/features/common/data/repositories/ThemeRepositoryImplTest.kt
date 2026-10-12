package com.victor7w7r.kmpNatively.features.common.data.repositories

import kotlin.test.Test
import kotlin.test.assertEquals

class ThemeRepositoryImplTest {
  @Test
  fun startsInDarkMode() {
    assertEquals(true, ThemeRepositoryImpl().isDarkMode)
  }

  @Test
  fun togglesBetweenDarkAndLightMode() {
    val repository = ThemeRepositoryImpl()

    repository.toggleTheme()
    assertEquals(false, repository.isDarkMode)

    repository.toggleTheme()
    assertEquals(true, repository.isDarkMode)
  }
}

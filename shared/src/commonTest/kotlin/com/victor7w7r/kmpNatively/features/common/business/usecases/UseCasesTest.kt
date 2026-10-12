package com.victor7w7r.kmpNatively.features.common.business.usecases

import arrow.core.None
import com.victor7w7r.kmpNatively.features.common.business.repositories.CoinsRepository
import com.victor7w7r.kmpNatively.features.common.business.repositories.ThemeRepository
import kotlinx.coroutines.flow.flowOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class UseCasesTest {
  @Test
  fun coinsUseCaseDelegatesToTheRepository() {
    val expectedFlow = flowOf(None)
    val repository =
      CoinsRepository {
        expectedFlow
      }

    assertSame(expectedFlow, CoinsUseCase(repository)())
  }

  @Test
  fun getThemeUseCaseReturnsTheRepositoryTheme() {
    val repository = FakeThemeRepository(isDarkMode = false)

    assertEquals(false, GetThemeUseCase(repository)())

    repository.isDarkMode = true
    assertEquals(true, GetThemeUseCase(repository)())
  }

  @Test
  fun toggleThemeUseCaseDelegatesToTheRepository() {
    val repository = FakeThemeRepository(isDarkMode = true)

    ToggleThemeUseCase(repository)()

    assertEquals(false, repository.isDarkMode)
    assertEquals(1, repository.toggleCount)
  }

  private class FakeThemeRepository(
    override var isDarkMode: Boolean,
  ) : ThemeRepository {
    var toggleCount = 0
      private set

    override fun toggleTheme() {
      toggleCount++
      isDarkMode = !isDarkMode
    }
  }
}

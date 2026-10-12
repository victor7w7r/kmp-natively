package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.v2.runComposeUiTest
import com.victor7w7r.kmpNatively.features.common.ui.services.StoreService
import kotlin.test.Test
import kotlin.test.assertEquals

class StorePresenterTest {
  @OptIn(ExperimentalTestApi::class)
  @Test
  fun submittingBlankTextShowsDismissibleErrorDialog() =
    runComposeUiTest {
      val presenter = StorePresenter(StoreService())

      setContent {
        Store(state = presenter.present())
      }

      onNodeWithText("Store state: Not yet.").assertExists()
      onNodeWithText("Submit").performClick()
      onNodeWithText("Is empty your TextField").assertExists()

      onNodeWithText("OK").performClick()

      onNodeWithText("Is empty your TextField").assertDoesNotExist()
    }

  @OptIn(ExperimentalTestApi::class)
  @Test
  fun submittingTextUpdatesTheSharedStoreState() =
    runComposeUiTest {
      val storeService = StoreService()
      val presenter = StorePresenter(storeService)

      setContent {
        Store(state = presenter.present())
      }

      onNodeWithText("here").performTextInput("Saved value")
      onNodeWithText("Submit").performClick()

      onNodeWithText("Store state: Yes, you write. Saved value").assertExists()
      assertEquals("Saved value", storeService.storeState)
    }
}

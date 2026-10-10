package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.victor7w7r.kmpNatively.core.resources.theme.LocalThemeIsDark

class HomePage : Screen {
  @Composable
  override fun Content() {
    var isDark by LocalThemeIsDark.current

    ElevatedButton(
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
      onClick = { isDark = !isDark },
      content = {
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "test")
      },
    )
  }
}

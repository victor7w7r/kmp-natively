package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.victor7w7r.kmpNatively.core.resources.theme.LocalThemeViewModel
import dev.zacsweers.metro.AppScope

@CircuitInject(HomeScreen::class, AppScope::class)
@Composable
fun Home(
  state: HomeScreen.State,
  modifier: Modifier = Modifier,
) {
  val themeViewModel = LocalThemeViewModel.current
  val isDark = themeViewModel.isDark

  ElevatedButton(
    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
    onClick = { themeViewModel.setTheme(!isDark) },
    content = {
      Spacer(Modifier.size(ButtonDefaults.IconSpacing))
      Text(text = "test")
    },
  )
}

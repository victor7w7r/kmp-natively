package com.victor7w7r.kmpNatively.features.common.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun Layout(content: @Composable () -> Unit) {
  // AppTheme(onThemeChange) {

  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Natively") },
        navigationIcon = {
          IconButton(onClick = { scope.launch { drawerState.open() } }) {
            Icon(
              imageVector = Icons.Default.Menu,
              contentDescription = "Open",
            )
          }
        },
      )
    },
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding)) { content() }
  }
  // }
}

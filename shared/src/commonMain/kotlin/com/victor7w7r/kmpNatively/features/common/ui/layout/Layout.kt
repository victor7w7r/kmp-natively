package com.victor7w7r.kmpNatively.features.common.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.composables.icons.materialicons.MaterialIcons
import com.composables.icons.materialicons.filled.Menu
import com.slack.circuit.runtime.Navigator
import kotlinx.coroutines.launch

@Composable
fun Layout(
  isDarkMode: Boolean,
  toggleTheme: () -> Unit,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit,
) {
  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Natively") },
        navigationIcon = {
          IconButton(onClick = { scope.launch { drawerState.open() } }) {
            Icon(
              imageVector = MaterialIcons.Filled.Menu,
              contentDescription = "Open",
            )
          }
        },
      )
    },
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding)) { content() }
  }
}

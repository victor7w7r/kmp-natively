package com.victor7w7r.kmpNatively

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.victor7w7r.kmpNatively.R
import com.victor7w7r.kmpNatively.core.modules.AppGraph
import dev.zacsweers.metro.createGraph

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.Theme_App)
    val app = createGraph<AppGraph>().app
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent { app() }
  }
}

@Preview
@Composable
private fun AppAndroidPreview() {
  createGraph<AppGraph>().app()
}

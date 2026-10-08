package com.victor7w7r.kmpNatively

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.victor7w7r.kmpNatively.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    // initKoin { androidContext(this@MainApplication) }
  }
}

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent { App() }
  }
}

@Preview
@Composable
fun AppAndroidPreview() {
  App()
}

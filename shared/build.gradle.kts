import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.androidMultiplatformLibrary)
  alias(libs.plugins.composeCompiler)
  alias(libs.plugins.composeMultiplatform)
  alias(libs.plugins.koinCompiler)
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinSerialization)
  alias(libs.plugins.ksp)
  alias(libs.plugins.ktorfit)
}

kotlin {
  android {
    namespace = "com.v7w7r.kmpNatively.shared"
    compileSdk =
      libs.versions.android.compileSdk
        .get()
        .toInt()
    minSdk =
      libs.versions.android.minSdk
        .get()
        .toInt()
    compilerOptions { jvmTarget = JvmTarget.JVM_17 }
    androidResources {
      enable = true
    }
    withHostTest {
      isIncludeAndroidResources = true
    }
    withDeviceTestBuilder {
      sourceSetTreeName = "test"
    }.configure {
      instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
  }

  js {
    browser()
    binaries.executable()
  }

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
    binaries.executable()
  }

  listOf(
    iosArm64(),
    iosSimulatorArm64(),
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Shared"
      isStatic = true
    }
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.androidx.lifecycle.runtimeCompose)
      implementation(libs.androidx.lifecycle.viewmodelCompose)
      implementation(libs.compose.components.resources)
      implementation(libs.compose.foundation)
      implementation(libs.compose.material3)
      implementation(libs.compose.runtime)
      implementation(libs.compose.ui)
      implementation(libs.compose.uiToolingPreview)
      implementation(libs.koin.annotations)
      implementation(libs.koin.core)
      implementation(libs.koin.compose)
      implementation(libs.koin.compose.viewmodel)
      implementation(libs.koin.compose.viewmodel.navigation)
      implementation(libs.kotlin.automapper.annotation)
      implementation(libs.kotlinx.coroutines.core)
      implementation(libs.ktorfit)
      implementation(libs.serialization.json)
      implementation(libs.content.negotiation)
      implementation(libs.kotlinx.json)
    }

    androidMain.dependencies {
      implementation(libs.compose.uiToolingPreview)
      implementation(libs.compose.uiTooling)
      implementation(libs.koin.android)
      implementation(libs.kotlinx.coroutines.android)
    }

    jsMain.dependencies {
      implementation(libs.wrappers.browser)
    }

    iosMain.dependencies {
    }

    commonTest.dependencies {
      implementation(kotlin("test"))
      implementation(libs.kotlinx.coroutines.test)
    }
  }
}

dependencies {
  androidRuntimeClasspath(libs.compose.uiTooling)
  // add("kspJs", libs.kotlin.automapper.processor)
  // add("kspIosArm64", libs.kotlin.automapper.processor)
}

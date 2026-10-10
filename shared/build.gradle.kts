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
  sourceSets {
    commonMain.dependencies {
      implementation(libs.androidx.lifecycle.runtimeCompose)
      implementation(libs.androidx.lifecycle.viewmodelCompose)
      implementation(libs.arrow.core)
      implementation(libs.arrow.fx.coroutines)
      implementation(libs.compose.components.resources)
      implementation(libs.compose.foundation)
      implementation(libs.compose.material3)
      implementation(libs.compose.runtime)
      implementation(libs.compose.ui)
      implementation(libs.compose.uiToolingPreview)
      implementation(libs.content.negotiation)
      implementation(libs.koin.annotations)
      implementation(libs.koin.compose)
      implementation(libs.koin.compose.viewmodel)
      implementation(libs.koin.compose.viewmodel.navigation)
      implementation(libs.koin.core)
      implementation(libs.kotlinx.coroutines.core)
      implementation(libs.kotlinx.json)
      implementation(libs.ktorfit)
      implementation(libs.serialization.json)
      implementation(libs.voyager.koin)
      implementation(libs.voyager.navigator)
      implementation(libs.voyager.screenModel)
      implementation(libs.voyager.transitions)
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
}

dependencies {
  androidRuntimeClasspath(libs.compose.uiTooling)
  with(libs.ktorfit.compiler) {
    add("kspCommonMainMetadata", this)
    add("kspAndroid", this)
    add("kspJs", this)
    add("kspWasmJs", this)
    add("kspIosArm64", this)
    add("kspIosSimulatorArm64", this)
  }
}

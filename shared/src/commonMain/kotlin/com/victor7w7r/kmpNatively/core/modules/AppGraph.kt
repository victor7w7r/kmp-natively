package com.victor7w7r.kmpNatively.core.modules

import com.victor7w7r.kmpNatively.AppClass
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph

@DependencyGraph(AppScope::class)
interface AppGraph {
  val app: AppClass
}

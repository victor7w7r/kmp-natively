package com.victor7w7r.kmpNatively

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform

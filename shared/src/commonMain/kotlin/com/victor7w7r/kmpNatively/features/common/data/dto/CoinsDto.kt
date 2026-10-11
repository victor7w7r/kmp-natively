package com.victor7w7r.kmpNatively.features.common.data.dto

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class CoinsDto(
  val symbol: String,
  val name: String,
  val iconUrl: String,
  val price: Double,
  val change: Double,
)

package com.victor7w7r.kmpNatively.features.common.data.dto

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class BinanceDto(
  val price: String,
  val symbol: String,
)

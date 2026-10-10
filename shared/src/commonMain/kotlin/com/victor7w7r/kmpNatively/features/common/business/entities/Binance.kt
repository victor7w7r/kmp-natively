package com.victor7w7r.kmpNatively.features.common.business.entities

import androidx.compose.runtime.Immutable

@Immutable
data class Binance(
  val price: String,
  val symbol: String,
)

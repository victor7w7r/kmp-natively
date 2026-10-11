package com.victor7w7r.kmpNatively.features.common.business.entities

import androidx.compose.runtime.Immutable

@Immutable
data class Coins(
  val iconUrl: String,
  val name: String,
  val symbol: String,
  val formattedPrice: String,
  val formattedChange: String,
  val isPositive: Boolean,
)

package com.victor7w7r.kmpNatively.features.common.business.entities

import kotlinx.serialization.Serializable

@Serializable
data class Bitcoin(
  val price: String,
  val symbol: String,
) {
  constructor() : this("", "ERR")
}

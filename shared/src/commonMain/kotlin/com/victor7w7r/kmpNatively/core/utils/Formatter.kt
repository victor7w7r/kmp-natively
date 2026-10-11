package com.victor7w7r.kmpNatively.core.utils

expect fun formatFiat(
  amount: Double,
  showDecimal: Boolean = true,
): String

expect fun formatPercentage(amount: Double): String

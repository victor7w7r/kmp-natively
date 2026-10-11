package com.victor7w7r.kmpNatively.core.utils

import java.text.DecimalFormat

actual fun formatFiat(
  amount: Double,
  showDecimal: Boolean,
): String {
  val formatter =
    when {
      showDecimal.not() -> DecimalFormat("#,###")
      amount >= 1 -> DecimalFormat("#,###.00")
      amount >= 0.01 -> DecimalFormat("0.00")
      else -> DecimalFormat("0.00000000")
    }
  return "$ " + formatter.format(amount)
}

actual fun formatPercentage(amount: Double): String {
  val prefix = if (amount >= 0) "+" else ""
  return prefix + DecimalFormat("0.00").format(amount) + " %"
}

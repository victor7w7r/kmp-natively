package com.victor7w7r.kmpNatively.core.utils

private fun nativeFormatNumber(
  value: Double,
  minDigits: Int,
  maxDigits: Int,
) = js(
  """
        new Intl.NumberFormat('en-US', {
            minimumFractionDigits: minDigits,
            maximumFractionDigits: maxDigits
        }).format(value)
    """,
) as String

actual fun formatFiat(
  amount: Double,
  showDecimal: Boolean,
): String {
  val minDigits = if (showDecimal) 2 else 0
  val maxDigits = if (showDecimal) 2 else 8

  // Usando el Intl.NumberFormat nativo de JS
  val formatted = nativeFormatNumber(amount, minDigits, maxDigits)
  return "$ $formatted"
}

actual fun formatPercentage(amount: Double): String {
  val prefix = if (amount >= 0) "+" else ""
  val formatted = nativeFormatNumber(amount, 2, 2)
  return "$prefix$formatted %"
}

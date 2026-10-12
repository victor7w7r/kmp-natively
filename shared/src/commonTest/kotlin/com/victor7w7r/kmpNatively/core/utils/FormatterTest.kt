package com.victor7w7r.kmpNatively.core.utils

import kotlin.test.Test
import kotlin.test.assertTrue

class FormatterTest {
  @Test
  fun formatFiatPrefixesEveryValueWithTheCurrency() {
    val formattedValues =
      listOf(
        formatFiat(1234.56),
        formatFiat(0.5),
        formatFiat(0.005),
        formatFiat(1234.56, showDecimal = false),
      )

    assertTrue(formattedValues.all { it.startsWith("$ ") })
  }

  @Test
  fun formatPercentageUsesAnExplicitSignAndPercentSuffix() {
    val positive = formatPercentage(2.5)
    val negative = formatPercentage(-2.5)
    val zero = formatPercentage(0.0)

    assertTrue(positive.startsWith("+"))
    assertTrue(negative.startsWith("-"))
    assertTrue(zero.startsWith("+"))
    assertTrue(listOf(positive, negative, zero).all { it.endsWith(" %") })
  }
}

package com.victor7w7r.kmpNatively.features.common.data.datasources

import com.victor7w7r.kmpNatively.features.common.data.dto.CoinsDto
import kotlinx.serialization.SerializationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith

class CoinsResponseDecoderTest {
  @Test
  fun decodesCoinsAndIgnoresUnknownFields() {
    val response =
      """
      {
        "data": {
          "coins": [
            {
              "symbol": "BTC",
              "name": "Bitcoin",
              "iconUrl": "btc.png",
              "price": 68000.25,
              "change": -0.5,
              "rank": 1
            }
          ]
        },
        "timestamp": 123
      }
      """.trimIndent()

    assertEquals(
      listOf(CoinsDto("BTC", "Bitcoin", "btc.png", 68000.25, -0.5)),
      decodeCoinsResponse(response),
    )
  }

  @Test
  fun returnsAnEmptyListWhenTheCoinsPayloadIsMissing() {
    assertEquals(emptyList(), decodeCoinsResponse("""{"data":{}}"""))
    assertEquals(emptyList(), decodeCoinsResponse("""{"meta":{"count":0}}"""))
  }

  @Test
  fun rejectsMalformedJson() {
    assertFails {
      decodeCoinsResponse("""{"data":""")
    }
  }

  @Test
  fun rejectsCoinsWithMissingRequiredFields() {
    assertFailsWith<SerializationException> {
      decodeCoinsResponse("""{"data":{"coins":[{"symbol":"BTC"}]}}""")
    }
  }
}

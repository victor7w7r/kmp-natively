package com.victor7w7r.kmpNatively.features.common.data.datasources

import com.victor7w7r.kmpNatively.features.common.data.dto.CoinsDto
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.*
import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.reflect.typeInfo
import kotlinx.serialization.json.*

class CoinsResponseConverterFactory : Converter.Factory {
  override fun suspendResponseConverter(
    typeData: TypeData,
    ktorfit: Ktorfit,
  ): Converter.SuspendResponseConverter<HttpResponse, *>? {
    if (typeData.typeInfo == typeInfo<List<CoinsDto>>()) {
      return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
        override suspend fun convert(result: KtorfitResult): Any =
          when (result) {
            is KtorfitResult.Failure -> {
              throw result.throwable
            }

            is KtorfitResult.Success -> {
              val customJson = Json { ignoreUnknownKeys = true }

              return result.response
                .bodyAsText()
                .let { customJson.decodeFromString<Map<String, JsonElement>>(it) }
                .let { it["data"]?.jsonObject?.get("coins")?.jsonArray }
                ?.let { jsonArray -> customJson.decodeFromJsonElement<List<CoinsDto>>(jsonArray) }
                ?: emptyList<CoinsDto>()
            }
          }
      }
    }

    return null
  }
}

interface CoinsRemoteDataSource {
  @GET("coins")
  suspend fun getCurrencies(): List<CoinsDto>
}

package com.victor7w7r.kmpNatively.features.common.data.datasources

import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.Field
import de.jensklingenberg.ktorfit.http.FormUrlEncoded
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path

// /ticker/price?symbol=BTCUSDT

interface BinanceRemoteDataSource {
	@GET("api/v3/account")
	suspend fun getAccountInfo(): String

	@POST("api/v3/order")
	@FormUrlEncoded
	suspend fun createOrder(
		@Field("symbol") symbol: String,
		@Field("side") side: String,
		@Field("type") type: String,
		@Field("quantity") quantity: String,
		@Field("price") price: String? = null,
		@Field("timeInForce") timeInForce: String? = null,
	): String

	@PUT("api/v3/order")
	@FormUrlEncoded
	suspend fun updateOrder(
		@Field("symbol") symbol: String,
		@Field("orderId") orderId: Long,
		@Field("quantity") quantity: String? = null,
		@Field("price") price: String? = null,
	): String

	@DELETE("api/v3/order")
	suspend fun cancelOrder(
		@Path("symbol") symbol: String,
		@Path("orderId") orderId: Long,
	): String
}

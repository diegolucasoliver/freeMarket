package com.dmlo.freemarket.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

class SearchResponse(
    @SerializedName("results") val results: List<ProductResponse>
)

class ProductResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: BigDecimal,
    @SerializedName("original_price") val originalPrice: BigDecimal?,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("condition") val condition: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("installments") val installments: InstallmentResponse?,
    @SerializedName("shipping") val shipping: ShippingResponse
)

class InstallmentResponse(
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("amount") val amount: BigDecimal
)

class ShippingResponse(
    @SerializedName("free_shipping") val freeShipping: Boolean
)
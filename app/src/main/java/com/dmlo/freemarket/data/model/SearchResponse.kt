package com.dmlo.freemarket.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

class SearchResponse(
    @SerializedName("site_id") val siteId: String,
    @SerializedName("query") val query: String?,
    @SerializedName("paging") val paging: PagingResponse,
    @SerializedName("results") val results: List<ProductResponse>
)

class PagingResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("primary_results") val primaryResults: Int
)

class ProductResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: BigDecimal,
    @SerializedName("original_price") val originalPrice: BigDecimal?,
    @SerializedName("sale_price") val salePrice: BigDecimal?,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("condition") val condition: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("installments") val installments: InstallmentResponse?,
    @SerializedName("shipping") val shipping: ShippingResponse
)

class InstallmentResponse(
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("rate") val rate: Int,
    @SerializedName("amount") val amount: BigDecimal,
    @SerializedName("currency_id") val currencyId: String
)

class ShippingResponse(
    @SerializedName("free_shipping") val freeShipping: Boolean
)
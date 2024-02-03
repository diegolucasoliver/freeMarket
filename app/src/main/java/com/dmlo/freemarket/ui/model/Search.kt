package com.dmlo.freemarket.ui.model

import com.dmlo.freemarket.data.model.InstallmentResponse
import com.dmlo.freemarket.data.model.PagingResponse
import com.dmlo.freemarket.data.model.ProductResponse
import com.dmlo.freemarket.data.model.SearchResponse
import java.math.BigDecimal

class Search(
    val siteId: String,
    val query: String?,
    val paging: Paging,
    val results: List<Product>
) {
    constructor(response: SearchResponse) : this(
        siteId = response.siteId,
        query = response.query,
        paging = Paging(response.paging),
        results = response.results.map { Product(it) }
    )
}

class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primaryResults: Int
) {
    constructor(response: PagingResponse) : this(
        total = response.total,
        offset = response.offset,
        limit = response.limit,
        primaryResults = response.primaryResults
    )
}

class Product(
    val id: String,
    val title: String,
    val price: BigDecimal,
    val originalPrice: BigDecimal?,
    val salePrice: BigDecimal?,
    val availableQuantity: Int,
    val condition: String,
    val thumbnail: String,
    val installments: Installment?,
    val freeShipping: Boolean
) {
    constructor(response: ProductResponse) : this(
        id = response.id,
        title = response.title,
        price = response.price,
        originalPrice = response.originalPrice,
        salePrice = response.salePrice,
        availableQuantity = response.availableQuantity,
        condition = response.condition,
        thumbnail = response.thumbnail,
        installments = response.installments?.let { Installment(it) },
        freeShipping = response.shipping.freeShipping
    )
}

class Installment(
    val quantity: Int,
    val rate: Int,
    val amount: BigDecimal,
    val currencyId: String
) {
    constructor(response: InstallmentResponse) : this(
        quantity = response.quantity,
        rate = response.rate,
        amount = response.amount,
        currencyId = response.currencyId
    )
}
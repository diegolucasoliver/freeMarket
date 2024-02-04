package com.dmlo.freemarket.repository.model

import com.dmlo.freemarket.data.model.InstallmentResponse
import com.dmlo.freemarket.data.model.ProductResponse
import com.dmlo.freemarket.data.model.SearchResponse
import java.math.BigDecimal

class Search(
    val results: List<Product> = emptyList()
) {
    constructor(response: SearchResponse) : this(
        results = response.results.map { Product(it) }
    )
}

class Product(
    val id: String,
    val title: String,
    val price: BigDecimal,
    val originalPrice: BigDecimal?,
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
        availableQuantity = response.availableQuantity,
        condition = response.condition,
        thumbnail = response.thumbnail,
        installments = response.installments?.let { Installment(it) },
        freeShipping = response.shipping.freeShipping
    )
}

class Installment(
    val quantity: Int,
    val amount: BigDecimal
) {
    constructor(response: InstallmentResponse) : this(
        quantity = response.quantity,
        amount = response.amount
    )
}
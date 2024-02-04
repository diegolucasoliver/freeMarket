package com.dmlo.freemarket.repository

import com.dmlo.freemarket.data.datasource.DescriptionDataSource
import com.dmlo.freemarket.repository.model.ProductDescription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DescriptionRepository(
    private val dataSource: DescriptionDataSource
) {

    fun fetchDescription(itemId: String): Flow<ProductDescription> =
        dataSource.fetchProduct(itemId).map { ProductDescription(it) }
}
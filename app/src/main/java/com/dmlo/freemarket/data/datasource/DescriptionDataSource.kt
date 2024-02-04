package com.dmlo.freemarket.data.datasource

import com.dmlo.freemarket.data.Api
import com.dmlo.freemarket.data.model.ProductDescriptionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DescriptionDataSource(
    private val api: Api
) {

    fun fetchProduct(itemId: String): Flow<ProductDescriptionResponse> = flow {
        emit(api.getProductDescription(itemId))
    }
}
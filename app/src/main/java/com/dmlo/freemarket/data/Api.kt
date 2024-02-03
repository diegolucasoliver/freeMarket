package com.dmlo.freemarket.data

import com.dmlo.freemarket.data.model.ProductDescriptionResponse
import com.dmlo.freemarket.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/sites/{site_id}/search?q={product}")
    abstract fun getProducts(
        @Path("site_id") siteId: String,
        @Path("product") product: String
    ) : Flow<SearchResponse>

    @GET("/items/{item_id}/description")
    abstract fun getProductDescription(
        @Path("item_id") itemId: String
    ) : Flow<ProductDescriptionResponse>
}
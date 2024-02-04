package com.dmlo.freemarket.data

import com.dmlo.freemarket.data.model.ProductDescriptionResponse
import com.dmlo.freemarket.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/sites/{site_id}/search")
    suspend fun getItems(
        @Path("site_id") siteId: String,
        @Query("q") product: String
    ) : SearchResponse

    @GET("/items/{item_id}/description")
    suspend fun getProductDescription(
        @Path("item_id") itemId: String
    ) : ProductDescriptionResponse
}
package com.dmlo.freemarket.data.datasource

import com.dmlo.freemarket.data.Api
import com.dmlo.freemarket.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemsDataSource(
    private val api: Api
) {

    fun fetchItems(query: String, siteId: String = "MLB"): Flow<SearchResponse> = flow {
        emit(api.getItems(siteId, query))
    }
}
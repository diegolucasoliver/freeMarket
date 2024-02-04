package com.dmlo.freemarket.repository

import com.dmlo.freemarket.data.datasource.ItemsDataSource
import com.dmlo.freemarket.ui.model.Search
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemsRepository(
    private val dataSource: ItemsDataSource
) {

    fun fecthItems(query: String): Flow<Search> =
        dataSource.fetchItems(query).map { Search(it) }
}
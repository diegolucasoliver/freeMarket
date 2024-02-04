package com.dmlo.freemarket.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmlo.freemarket.repository.DescriptionRepository
import com.dmlo.freemarket.repository.ItemsRepository
import com.dmlo.freemarket.ui.model.ProductDescription
import com.dmlo.freemarket.ui.model.Search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchRepository: ItemsRepository,
    private val descriptionRepository: DescriptionRepository
) : ViewModel() {

    private val _itemsUiState = MutableStateFlow<FreeMarketUiState<Search>>(
        FreeMarketUiState.Success(Search())
    )
    val itemsUiState: StateFlow<FreeMarketUiState<Search>>
        get() = _itemsUiState

    private val _descriptionUiState = MutableStateFlow<FreeMarketUiState<ProductDescription>>(
        FreeMarketUiState.Success(ProductDescription())
    )

    val descriptionUiState: StateFlow<FreeMarketUiState<ProductDescription>>
        get() = _descriptionUiState

    fun fetchItems(query: String) {
        viewModelScope.launch {
            _itemsUiState.value = FreeMarketUiState.Loading

            try {
                searchRepository.fecthItems(query)
                    .collect { items ->
                        _itemsUiState.value = FreeMarketUiState.Success(items)
                    }
            } catch (e: Throwable) {
                _itemsUiState.value = FreeMarketUiState.Error(e)
            }
        }
    }

    fun fetchDescription(itemId: String) {
        viewModelScope.launch {
            _descriptionUiState.value = FreeMarketUiState.Loading

            try {
                descriptionRepository.fetchDescription(itemId)
                    .collect { description ->
                        _descriptionUiState.value = FreeMarketUiState.Success(description)
                    }
            } catch (e: Throwable) {
                _descriptionUiState.value = FreeMarketUiState.Error(e)
            }

        }
    }
}

sealed class FreeMarketUiState<out T> {
    object Loading : FreeMarketUiState<Nothing>()
    data class Success<T>(val data: T) : FreeMarketUiState<T>()
    data class Error(val t: Throwable) : FreeMarketUiState<Nothing>()
}

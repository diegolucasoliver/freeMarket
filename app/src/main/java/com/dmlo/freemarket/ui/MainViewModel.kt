package com.dmlo.freemarket.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmlo.freemarket.repository.DescriptionRepository
import com.dmlo.freemarket.repository.ItemsRepository
import com.dmlo.freemarket.repository.model.ProductDescription
import com.dmlo.freemarket.repository.model.Search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
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

            searchRepository.fecthItems(query)
                .catch { e ->
                    _itemsUiState.value = FreeMarketUiState.Error(e)
                }
                .collect { items ->
                    _itemsUiState.value = FreeMarketUiState.Success(items)
                }
        }
    }

    fun fetchDescription(itemId: String) {
        viewModelScope.launch {
            _descriptionUiState.value = FreeMarketUiState.Loading

            descriptionRepository.fetchDescription(itemId)
                .catch { e ->
                    _descriptionUiState.value = FreeMarketUiState.Error(e)
                }
                .collect { description ->
                    _descriptionUiState.value = FreeMarketUiState.Success(description)
                }

        }
    }
}

sealed class FreeMarketUiState<out T> {
    data object Loading : FreeMarketUiState<Nothing>()
    data class Success<T>(val data: T) : FreeMarketUiState<T>()
    data class Error(val t: Throwable) : FreeMarketUiState<Nothing>()
}

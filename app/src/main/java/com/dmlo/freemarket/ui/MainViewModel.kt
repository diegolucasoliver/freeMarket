package com.dmlo.freemarket.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmlo.freemarket.repository.ItemsRepository
import com.dmlo.freemarket.ui.model.Search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchRepository: ItemsRepository
) : ViewModel() {

    private val _itemsUiState = MutableStateFlow<FreeMarketUiState<Search>>(
        FreeMarketUiState.Success(Search())
    )
    val itemsUiState: StateFlow<FreeMarketUiState<Search>>
        get() = _itemsUiState

    fun searchItems(query: String) {
        viewModelScope.launch {
            _itemsUiState.value = FreeMarketUiState.Loading

            searchRepository.fecthItems(query)
                .collect { items ->
                    _itemsUiState.value = FreeMarketUiState.Success(items)
                }
        }
    }
}

sealed class FreeMarketUiState<out T> {
    object Loading : FreeMarketUiState<Nothing>()
    data class Success<T>(val data: T) : FreeMarketUiState<T>()
    data class Error(val t: Throwable) : FreeMarketUiState<Nothing>()
}

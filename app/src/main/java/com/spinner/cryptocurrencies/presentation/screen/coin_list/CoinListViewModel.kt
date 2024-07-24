package com.spinner.cryptocurrencies.presentation.screen.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spinner.cryptocurrencies.common.ResourceState
import com.spinner.cryptocurrencies.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            getCoinsUseCase().collect { result ->
                when (result) {
                    is ResourceState.Success -> {
                        _state.value = CoinListState(coins = result.data ?: emptyList())
                    }
                    is ResourceState.Error -> {
                        _state.value = CoinListState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                    is ResourceState.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }
                }
            }
        }
    }
}
package com.spinner.cryptocurrencies.presentation.screen.coin_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spinner.cryptocurrencies.common.ResourceState
import com.spinner.cryptocurrencies.domain.usecase.GetCoinDetailsUseCase
import com.spinner.cryptocurrencies.presentation.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state: StateFlow<CoinDetailsState>
        field = MutableStateFlow(CoinDetailsState())

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        viewModelScope.launch {
            getCoinDetailsUseCase(coinId).collect { result ->
                when (result) {
                    is ResourceState.Success -> {
                        state.value = CoinDetailsState(coinDetails = result.data)
                    }
                    is ResourceState.Error -> {
                        state.value = CoinDetailsState(error = result.message)
                    }
                    is ResourceState.Loading -> {
                        state.value = CoinDetailsState(isLoading = true)
                    }
                }
            }
        }
    }
}
package com.spinner.cryptocurrencies.presentation.screen.coin_list

import androidx.compose.runtime.Immutable
import com.spinner.cryptocurrencies.domain.model.Coin

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
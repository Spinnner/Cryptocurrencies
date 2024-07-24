package com.spinner.cryptocurrencies.presentation.screen.coin_list

import com.spinner.cryptocurrencies.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
package com.spinner.cryptocurrencies.presentation.screen.coin_details

import com.spinner.cryptocurrencies.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)
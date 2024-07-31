package com.spinner.cryptocurrencies.presentation.screen.coin_details

import androidx.compose.runtime.Immutable
import com.spinner.cryptocurrencies.domain.model.CoinDetails

@Immutable
data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)
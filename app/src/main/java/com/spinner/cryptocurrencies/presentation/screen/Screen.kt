package com.spinner.cryptocurrencies.presentation.screen

import kotlinx.serialization.Serializable

sealed class Screen() {
    @Serializable
    data object CoinList: Screen()

    @Serializable
    data class CoinDetails(val coinId: String): Screen()
}
package com.spinner.cryptocurrencies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PriceChangePercentageInCurrency(
    val usd: Double,
    val eur: Double,
)

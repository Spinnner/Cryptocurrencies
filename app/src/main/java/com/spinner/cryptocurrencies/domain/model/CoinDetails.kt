package com.spinner.cryptocurrencies.domain.model

data class CoinDetails(
    val id: String,
    val symbol: String,
    val name: String,
    val description: String,
    val image: String,
    val priceChangePercentage24h: Double,
    val priceChangePercentage7d: Double,
    val priceChangePercentage30d: Double,
)
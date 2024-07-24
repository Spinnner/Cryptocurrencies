package com.spinner.cryptocurrencies.domain.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val price: Double,
    val rank: Int,
    val priceChangePercentage24h: Double,
)

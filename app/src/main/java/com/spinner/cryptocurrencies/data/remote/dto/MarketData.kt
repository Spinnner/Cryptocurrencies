package com.spinner.cryptocurrencies.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketData(
    @SerialName("current_price")
    val currentPrice: CurrentPrice,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("price_change_24h")
    val priceChange24h: Double,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerialName("price_change_percentage_7d")
    val priceChangePercentage7d: Double,
    @SerialName("price_change_percentage_14d")
    val priceChangePercentage14d: Double,
    @SerialName("price_change_percentage_30d")
    val priceChangePercentage30d: Double,
    @SerialName("price_change_percentage_60d")
    val priceChangePercentage60d: Double,
    @SerialName("price_change_percentage_200d")
    val priceChangePercentage200d: Double,
    @SerialName("price_change_percentage_1y")
    val priceChangePercentage1y: Double,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerialName("price_change_24h_in_currency")
    val priceChange24hInCurrency: PriceChangeInCurrency,
    @SerialName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_60d_in_currency")
    val priceChangePercentage60dInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: PriceChangePercentageInCurrency,
    @SerialName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: PriceChangePercentageInCurrency,
    @SerialName("market_cap_change_24h_in_currency")
    val marketCapChange24hInCurrency: PriceChangeInCurrency,
    @SerialName("market_cap_change_percentage_24h_in_currency")
    val marketCapChangePercentage24hInCurrency: PriceChangePercentageInCurrency,
    @SerialName("total_supply")
    val totalSupply: Double,
    @SerialName("max_supply")
    val maxSupply: Double?,
    @SerialName("circulating_supply")
    val circulatingSupply: Double?,
    @SerialName("last_updated")
    val lastUpdated: String
)
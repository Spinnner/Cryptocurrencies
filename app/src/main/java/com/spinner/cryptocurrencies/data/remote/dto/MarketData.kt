package com.spinner.cryptocurrencies.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MarketData(
    @SerializedName("current_price")
    val currentPrice: CurrentPrice,
    @SerializedName("total_value_locked")
    val totalValueLocked: Any,
    @SerializedName("mcap_to_tvl_ratio")
    val mcapToTvlRatio: Any,
    @SerializedName("fdv_to_tvl_ratio")
    val fdvToTvlRatio: Any,
    val roi: Any,
    val ath: Ath,
    @SerializedName("ath_change_percentage")
    val athChangePercentage: AthChangePercentage,
    @SerializedName("ath_date")
    val athDate: AthDate,
    val atl: Atl,
    @SerializedName("atl_change_percentage")
    val atlChangePercentage: AtlChangePercentage,
    @SerializedName("atl_date")
    val atlDate: AtlDate,
    @SerializedName("market_cap")
    val marketCap: MarketCap,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("fully_diluted_valuation")
    val fullyDilutedValuation: FullyDilutedValuation,
    @SerializedName("market_cap_fdv_ratio")
    val marketCapFdvRatio: Double,
    @SerializedName("total_volume")
    val totalVolume: TotalVolume,
    @SerializedName("high_24h")
    val high24h: High24h,
    @SerializedName("low_24h")
    val low24h: Low24h,
    @SerializedName("price_change_24h")
    val priceChange24h: Double,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerializedName("price_change_percentage_7d")
    val priceChangePercentage7d: Double,
    @SerializedName("price_change_percentage_14d")
    val priceChangePercentage14d: Double,
    @SerializedName("price_change_percentage_30d")
    val priceChangePercentage30d: Double,
    @SerializedName("price_change_percentage_60d")
    val priceChangePercentage60d: Double,
    @SerializedName("price_change_percentage_200d")
    val priceChangePercentage200d: Double,
    @SerializedName("price_change_percentage_1y")
    val priceChangePercentage1y: Double,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerializedName("price_change_24h_in_currency")
    val priceChange24hInCurrency: PriceChange24hInCurrency,
    @SerializedName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: PriceChangePercentage1hInCurrency,
    @SerializedName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: PriceChangePercentage24hInCurrency,
    @SerializedName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: PriceChangePercentage7dInCurrency,
    @SerializedName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: PriceChangePercentage7dInCurrency,
    @SerializedName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: PriceChangePercentage7dInCurrency,
    @SerializedName("price_change_percentage_60d_in_currency")
    val priceChangePercentage60dInCurrency: PriceChangePercentage7dInCurrency,
    @SerializedName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: PriceChangePercentage7dInCurrency,
    @SerializedName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: PriceChangePercentage1yInCurrency,
    @SerializedName("market_cap_change_24h_in_currency")
    val marketCapChange24hInCurrency: MarketCapChange24hInCurrency,
    @SerializedName("market_cap_change_percentage_24h_in_currency")
    val marketCapChangePercentage24hInCurrency: MarketCapChangePercentage24hInCurrency,
    @SerializedName("total_supply")
    val totalSupply: Double,
    @SerializedName("max_supply")
    val maxSupply: Double,
    @SerializedName("circulating_supply")
    val circulatingSupply: Double,
    @SerializedName("last_updated")
    val lastUpdated: String
)
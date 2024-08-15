package com.spinner.cryptocurrencies.data.remote.dto

import com.spinner.cryptocurrencies.domain.model.CoinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerialName("web_slug")
    val webSlug: String?,
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Int?,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String?,
    val categories: List<String>?,
    @SerialName("preview_listing")
    val previewListing: Boolean,
    val description: Description,
    val image: Image,
    @SerialName("country_origin")
    val countryOrigin: String,
    @SerialName("genesis_date")
    val genesisDate: String?,
    @SerialName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double?,
    @SerialName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double?,
    @SerialName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int?,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("market_data")
    val marketData: MarketData,
    @SerialName("last_updated")
    val lastUpdated: String,
)

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        id = id,
        symbol = symbol.uppercase(),
        name = name,
        description = description.en,
        price = marketData.currentPrice.usd,
        image = image.large,
        priceChangePercentage24h = marketData.priceChangePercentage24h,
        priceChangePercentage7d = marketData.priceChangePercentage7d,
        priceChangePercentage30d = marketData.priceChangePercentage30d,
    )
}
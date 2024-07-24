package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.spinner.cryptocurrencies.domain.model.CoinDetails

data class CoinDetailsDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerializedName("web_slug")
    val webSlug: String,
    @SerializedName("asset_platform_id")
    val assetPlatformId: Any,
    val platforms: Platforms,
    @SerializedName("detail_platforms")
    val detailPlatforms: DetailPlatforms,
    @SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Int,
    @SerializedName("hashing_algorithm")
    val hashingAlgorithm: String,
    val categories: List<String>,
    @SerializedName("preview_listing")
    val previewListing: Boolean,
    @SerializedName("public_notice")
    val publicNotice: Any,
    @SerializedName("additional_notices")
    val additionalNotices: List<Any>,
    val localization: Localization,
    val description: Description,
    val links: Links,
    val image: Image,
    @SerializedName("country_origin")
    val countryOrigin: String,
    @SerializedName("genesis_date")
    val genesisDate: String,
    @SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double,
    @SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double,
    @SerializedName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("market_data")
    val marketData: MarketData,
    @SerializedName("community_data")
    val communityData: CommunityData,
    @SerializedName("developer_data")
    val developerData: DeveloperData,
    @SerializedName("status_updates")
    val statusUpdates: List<Any>,
    @SerializedName("last_updated")
    val lastUpdated: String,
    val tickers: List<Ticker>
)

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        id = id,
        symbol = symbol,
        name = name,
        description = description.en,
        image = image.large,
        priceChangePercentage24h = marketData.priceChangePercentage24h,
        priceChangePercentage7d = marketData.priceChangePercentage7d,
        priceChangePercentage30d = marketData.priceChangePercentage30d,
    )
}
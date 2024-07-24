package com.spinner.cryptocurrencies.data.remote

import com.spinner.cryptocurrencies.common.Constants
import com.spinner.cryptocurrencies.data.remote.dto.CoinDetailsDto
import com.spinner.cryptocurrencies.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoingeckoApi {

    companion object {
        const val PATH_COINS = "${Constants.BASE_URL}/api/v3/coins"
        const val PATH_COINS_MARKET = "$PATH_COINS/markets"
        const val PATH_COIN_DETAILS = "$PATH_COINS/{coinId}"
    }

    @GET(PATH_COINS_MARKET)
    suspend fun getCoins(@Query("vs_currency") currency: String): List<CoinDto>

    @GET(PATH_COIN_DETAILS)
    suspend fun getCoinDetails(@Path("coinId") id: String): CoinDetailsDto
}
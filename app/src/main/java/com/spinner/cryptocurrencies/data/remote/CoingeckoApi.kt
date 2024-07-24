package com.spinner.cryptocurrencies.data.remote

import com.spinner.cryptocurrencies.data.remote.dto.CoinDetailsDto
import com.spinner.cryptocurrencies.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CoingeckoApi {

    @GET("/api/v3/coins/markets")
    suspend fun getCoins(@Query("vs_currency") currency: String): List<CoinDto>

    @GET("/api/v3/coins/{coinId}")
    suspend fun getCoinDetails(id: String): CoinDetailsDto
}
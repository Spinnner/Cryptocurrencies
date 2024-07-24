package com.spinner.cryptocurrencies.domain.repository

import com.spinner.cryptocurrencies.domain.model.Coin
import com.spinner.cryptocurrencies.domain.model.CoinDetails

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinDetails(id: String): CoinDetails
}
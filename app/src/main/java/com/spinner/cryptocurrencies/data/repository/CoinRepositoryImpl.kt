package com.spinner.cryptocurrencies.data.repository

import com.spinner.cryptocurrencies.common.Constants
import com.spinner.cryptocurrencies.data.remote.CoingeckoApi
import com.spinner.cryptocurrencies.data.remote.dto.toCoin
import com.spinner.cryptocurrencies.data.remote.dto.toCoinDetails
import com.spinner.cryptocurrencies.domain.model.Coin
import com.spinner.cryptocurrencies.domain.model.CoinDetails
import com.spinner.cryptocurrencies.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoingeckoApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins(Constants.CURRENCY).map { it.toCoin() }
    }

    override suspend fun getCoinDetails(id: String): CoinDetails {
        return api.getCoinDetails(id).toCoinDetails()
    }
}
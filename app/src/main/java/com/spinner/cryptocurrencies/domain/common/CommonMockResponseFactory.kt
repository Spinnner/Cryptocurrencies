package com.spinner.cryptocurrencies.domain.common

import com.spinner.cryptocurrencies.domain.model.Coin
import java.util.UUID

object CommonMockResponseFactory {

    fun createCoinList(): List<Coin> {
        return mutableListOf<Coin>().apply {
            add(Coin(id = UUID.randomUUID().toString(), symbol = "btc", name = "Bitcoin", price = 70_000.0, rank = 1, priceChangePercentage24h = 5.5))
            add(Coin(id = UUID.randomUUID().toString(), symbol = "eth", name = "Ethereum", price = 3400.0, rank = 2, priceChangePercentage24h = -33.7))
            add(Coin(id = UUID.randomUUID().toString(), symbol = "bnb", name = "Binance Coin", price = 538.0, rank = 3, priceChangePercentage24h = 12.0))
        }
    }
}
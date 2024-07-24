package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ConvertedLast(
    val btc: Double,
    val eth: Double,
    val usd: Int
)
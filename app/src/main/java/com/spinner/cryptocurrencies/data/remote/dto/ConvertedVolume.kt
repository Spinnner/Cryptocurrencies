package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ConvertedVolume(
    val btc: Int,
    val eth: Int,
    val usd: Int
)
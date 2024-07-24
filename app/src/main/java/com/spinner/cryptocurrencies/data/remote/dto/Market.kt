package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Market(
    val name: String,
    val identifier: String,
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean
)
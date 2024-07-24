package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Image(
    val thumb: String,
    val small: String,
    val large: String
)
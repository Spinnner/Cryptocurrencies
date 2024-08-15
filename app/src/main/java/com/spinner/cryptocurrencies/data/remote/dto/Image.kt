package com.spinner.cryptocurrencies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val thumb: String,
    val small: String,
    val large: String
)
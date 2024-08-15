package com.spinner.cryptocurrencies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrentPrice(
    val usd: Double,
    val eur: Double,
)
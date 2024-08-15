package com.spinner.cryptocurrencies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Description(
    val en: String,
    val de: String
)
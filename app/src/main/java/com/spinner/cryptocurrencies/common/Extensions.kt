package com.spinner.cryptocurrencies.common

fun Double.roundTo2Decimals(): Double {
    return String.format("%.2f", this).toDouble()
}
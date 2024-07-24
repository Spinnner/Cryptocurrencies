package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ReposUrl(
    val github: List<String>,
    val bitbucket: List<Any>
)
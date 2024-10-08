package com.spinner.cryptocurrencies.common

sealed class ResourceState<out T> {
    data class Success<out T>(val data: T) : ResourceState<T>()
    data class Error(val message: String) : ResourceState<Nothing>()
    object Loading : ResourceState<Nothing>()
}
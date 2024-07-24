package com.spinner.cryptocurrencies.presentation.screen

sealed class Screen(val route: String) {
    data object CoinListScreen: Screen("coin_list_screen")
    data object CoinDetailsScreen: Screen("coin_details_screen")
}
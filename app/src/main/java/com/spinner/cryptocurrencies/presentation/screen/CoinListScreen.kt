package com.spinner.cryptocurrencies.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.spinner.cryptocurrencies.domain.common.CommonMockResponseFactory
import com.spinner.cryptocurrencies.domain.model.Coin
import com.spinner.cryptocurrencies.presentation.CoinListViewModel
import com.spinner.cryptocurrencies.presentation.screen.coin_list.CoinListItemView
import com.spinner.cryptocurrencies.presentation.screen.coin_list.CoinListState
import com.spinner.cryptocurrencies.presentation.ui.UIModePreviews

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    CoinListContentView(state.value) { coin ->
        navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
    }
}

@Composable
private fun CoinListContentView(
    state: CoinListState,
    onCoinClicked: (coin: Coin) -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coins) { coin ->
                CoinListItemView(
                    coin = coin,
                    onItemClick = {
                        onCoinClicked(coin)
                    }
                )
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@UIModePreviews
@Composable
private fun CoinListContentPreview() {
    val state = CoinListState(coins = CommonMockResponseFactory.createCoinList())
    CoinListContentView(state = state) {}
}

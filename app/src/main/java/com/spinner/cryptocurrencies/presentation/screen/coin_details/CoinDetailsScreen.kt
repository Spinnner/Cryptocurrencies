package com.spinner.cryptocurrencies.presentation.screen.coin_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.spinner.cryptocurrencies.domain.common.CommonMockResponseFactory
import com.spinner.cryptocurrencies.domain.model.CoinDetails
import com.spinner.cryptocurrencies.presentation.common.AsyncCachedImage
import com.spinner.cryptocurrencies.presentation.ui.UIModePreviews

@Composable
fun CoinDetailsScreen(viewModel: CoinDetailsViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    CoinDetailsContentView(state.value)
}

@Composable
private fun CoinDetailsContentView(state: CoinDetailsState) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)
        .background(Color.Black)) {
        CoinDetailsMainView(state.coinDetails)
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

@Composable
private fun CoinDetailsMainView(coinDetails: CoinDetails?) {
    coinDetails?.let { coin ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            Text(
                text = "${coin.name} (${coin.symbol})",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$${coin.price}",
                color = Color.Yellow,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = coin.description,
                color = Color.Green,
                maxLines = 10,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            AsyncCachedImage(url = coin.image)
        }
    }
}

@UIModePreviews
@Composable
private fun CoinListContentPreview() {
    val state = CoinDetailsState(coinDetails = CommonMockResponseFactory.createCoinDetails())
    CoinDetailsContentView(state)
}
package com.spinner.cryptocurrencies.presentation.screen.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.spinner.cryptocurrencies.domain.common.CommonMockResponseFactory
import com.spinner.cryptocurrencies.domain.model.Coin
import com.spinner.cryptocurrencies.presentation.ui.UIModePreviews

@Composable
fun CoinListItemView(
    modifier: Modifier = Modifier,
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.width(160.dp),
            maxLines = 1,
            text = "${coin.rank}. ${coin.name} (${coin.symbol.uppercase()})",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis
        )
        Row {
            val priceChangeSymbol = if (coin.priceChangePercentage24h > 0) '+' else ""
            Text(
                color = Color.Yellow,
                text = "$${coin.price}",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                color = if (coin.priceChangePercentage24h > 0) Color.Green else Color.Red,
                text = "$priceChangeSymbol${coin.priceChangePercentage24h}%",
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@UIModePreviews
@Composable
private fun CoinListItemPreview() {
    CoinListItemView(modifier = Modifier.background(Color.Black), coin = CommonMockResponseFactory.createCoinList().first()) {}
}
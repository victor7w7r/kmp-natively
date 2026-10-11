package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.victor7w7r.kmpNatively.features.common.business.entities.Coins

@Composable
private fun CoinListItem(coin: Coins) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(horizontal = 150.dp)
        .clip(CircleShape)
        .background(Color(0xFF600f96).copy(alpha = 0.05f))
        .border(1.dp, Color(0xFF600f96).copy(alpha = 0.4f), CircleShape)
        .padding(horizontal = 16.dp, vertical = 12.dp),
  ) {
    SubcomposeAsyncImage(
      model = coin.iconUrl,
      contentDescription = null,
      contentScale = ContentScale.Fit,
      modifier = Modifier.padding(4.dp).clip(CircleShape).size(40.dp),
      loading = {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
        }
      },
      error = {
        Box(modifier = Modifier.fillMaxSize().background(Color.Gray))
      },
    )
    Spacer(modifier = Modifier.width(16.dp))
    Column(
      modifier = Modifier.weight(1f),
    ) {
      Text(
        text = coin.name,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = coin.symbol,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
      )
    }
    Spacer(modifier = Modifier.width(16.dp))
    Column(
      horizontalAlignment = Alignment.End,
    ) {
      Text(
        text = coin.formattedPrice,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = coin.formattedChange,
        color = if (coin.isPositive) Color(0xFFFFFFFF) else Color(0xFFC92061),
        fontSize = MaterialTheme.typography.titleSmall.fontSize,
      )
    }
  }
}

@Composable
fun CoinsList(
  coins: List<Coins>,
  modifier: Modifier = Modifier,
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier =
      Modifier
        .background(MaterialTheme.colorScheme.background),
  ) {
    LazyColumn(
      verticalArrangement = Arrangement.spacedBy(8.dp),
      contentPadding = WindowInsets.systemBars.asPaddingValues(),
      modifier = Modifier.fillMaxSize(),
    ) {
      items(coins) { coin -> CoinListItem(coin = coin) }
    }
  }
}

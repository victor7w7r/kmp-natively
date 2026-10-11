package com.victor7w7r.kmpNatively.features.common.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arrow.core.None
import arrow.core.Some
import com.slack.circuit.codegen.annotations.CircuitInject
import dev.zacsweers.metro.AppScope
import kmp_natively.shared.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@CircuitInject(HomeScreen::class, AppScope::class)
@Composable
fun Home(
  state: HomeScreen.State,
  modifier: Modifier = Modifier,
) {
  PullToRefreshBox(
    isRefreshing = state.isRefreshing,
    onRefresh = { state.eventSink(HomeScreen.Event.OnRefresh) },
    modifier = Modifier.fillMaxSize(),
  ) {
    Column(modifier = Modifier.fillMaxSize()) {
      Column(
        modifier = Modifier.weight(1f).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Image(
          painter =
            painterResource(
              if (state.isDarkMode) Res.drawable.brandwhite else Res.drawable.brand,
            ),
          contentDescription = "Brand",
          modifier =
            Modifier
              .width(350.dp)
              .height(115.dp),
          contentScale = ContentScale.Fit,
        )
        Text(
          text = "A Compose Multiplatform Template (/>w<)/",
          fontFamily =
            FontFamily(Font(Res.font.amina_reska)),
          textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
          text =
            if (state.storeText.isEmpty()) {
              "Store state: Not yet."
            } else {
              "Store state: Yes, you write. ${state.storeText}"
            },
          fontSize = 15.sp,
          textAlign = TextAlign.Center,
        )
        Text(
          text = "List of Coins:",
          color = MaterialTheme.colorScheme.onBackground,
          modifier = Modifier.padding(16.dp),
        )
      }

      Box(modifier = Modifier.weight(2f).fillMaxWidth()) {
        when (val result = state.coinsState) {
          is None -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
          }

          is Some -> {
            result.value.fold(
              ifLeft = { errorMsg -> Text(text = "ERROR: $errorMsg") },
              ifRight = { coinsList -> CoinsList(coinsList) },
            )
          }
        }
      }
    }
  }
}

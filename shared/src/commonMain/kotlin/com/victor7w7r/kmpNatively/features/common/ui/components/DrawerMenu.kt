package com.victor7w7r.kmpNatively.features.common.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.composables.icons.materialicons.MaterialIcons
import com.composables.icons.materialicons.filled.*
import kmp_natively.shared.generated.resources.*
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawerMenu(
  isDarkMode: Boolean,
  onToggleTheme: () -> Unit,
  onNavigateHome: () -> Unit,
  onNavigateStore: () -> Unit,
  modifier: Modifier = Modifier,
) {
  ModalDrawerSheet(modifier = modifier) {
    Column(
      modifier =
        Modifier
          .fillMaxHeight()
          .padding(horizontal = 16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Spacer(modifier = Modifier.weight(2f))

      Box(
        modifier =
          Modifier
            .fillMaxWidth()
            .height(160.dp),
        contentAlignment = Alignment.Center,
      ) {
        Image(
          painter =
            painterResource(
              if (isDarkMode) Res.drawable.aqua_light else Res.drawable.aqua_black,
            ),
          contentDescription = "Logo Aqua",
          contentScale = ContentScale.Fit,
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      NavigationDrawerItem(
        icon = { Icon(MaterialIcons.Filled.Home, contentDescription = "Home") },
        label = { Text("Home") },
        selected = false,
        onClick = onNavigateHome,
      )

      NavigationDrawerItem(
        icon = { Icon(MaterialIcons.Filled.Edit_note, contentDescription = "Store") },
        label = { Text("Store") },
        selected = false,
        onClick = onNavigateStore,
      )

      Spacer(modifier = Modifier.weight(8f))

      NavigationDrawerItem(
        icon = {
          Icon(
            if (isDarkMode) {
              MaterialIcons.Filled.Dark_mode
            } else {
              MaterialIcons.Filled.Light_mode
            },
            contentDescription = "Change Color Mode",
          )
        },
        label = { Text("Change Color Mode") },
        selected = false,
        onClick = onToggleTheme,
      )

      Spacer(modifier = Modifier.weight(15f))

      Image(
        painter =
          painterResource(
            if (isDarkMode) Res.drawable.brandwhite else Res.drawable.brand,
          ),
        contentDescription = "Brand",
        modifier =
          Modifier
            .width(250.dp)
            .height(75.dp),
        contentScale = ContentScale.Fit,
      )

      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

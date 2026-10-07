package com.victor7w7r.kmpNatively

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victor7w7r.kmpNatively.theme.AppTheme
import com.victor7w7r.kmpNatively.theme.LocalThemeIsDark

@Preview
@Composable
fun App(onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}) =
	AppTheme(onThemeChanged) {
		Column(
			modifier =
				Modifier
					.fillMaxSize()
					.windowInsetsPadding(WindowInsets.safeDrawing)
					.padding(16.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Text(
				text = "text2",
				style = MaterialTheme.typography.displayLarge,
			)
			ElevatedButton(
				modifier =
					Modifier
						.padding(horizontal = 8.dp, vertical = 4.dp)
						.widthIn(min = 200.dp),
				onClick = { },
				content = {
					Spacer(Modifier.size(ButtonDefaults.IconSpacing))
				},
			)

			var isDark by LocalThemeIsDark.current

			ElevatedButton(
				modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
				onClick = { isDark = !isDark },
				content = {
					Spacer(Modifier.size(ButtonDefaults.IconSpacing))
					Text(text = "test")
				},
			)
		}
	}

package com.victor7w7r.kmpNatively.features.common.ui.pages.store

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import dev.zacsweers.metro.AppScope

@CircuitInject(StoreScreen::class, AppScope::class)
@Composable
fun Store(
  state: StoreScreen.State,
  modifier: Modifier = Modifier,
) {
  BoxWithConstraints(modifier = modifier.fillMaxSize()) {
    val isMinMd = maxWidth >= 600.dp

    Column(
      modifier =
        Modifier
          .fillMaxSize()
          .padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        text = "Store Example",
        fontSize = if (isMinMd) 25.sp else 40.sp,
        textAlign = TextAlign.Center,
      )

      Spacer(modifier = Modifier.height(15.dp))

      Text(
        text = "Write anything in this form and send!",
        fontSize = if (isMinMd) 15.sp else 20.sp,
        textAlign = TextAlign.Center,
      )

      Spacer(modifier = Modifier.height(25.dp))

      OutlinedTextField(
        value = state.text,
        onValueChange = { newText ->
          state.eventSink(StoreScreen.Event.OnTextChanged(newText))
        },
        placeholder = { Text("here") },
        singleLine = true,
        modifier =
          Modifier
            .width(250.dp)
            .height(55.dp),
      )

      Spacer(modifier = Modifier.height(12.dp))
      ElevatedButton(onClick = { state.eventSink(StoreScreen.Event.SubmitText(state.text)) }) { Text("Submit") }
      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text =
          if (state.savedText.isEmpty()) {
            "Store state: Not yet."
          } else {
            "Store state: Yes, you write. ${state.text}"
          },
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
      )
    }
  }

  if (state.showDialog) {
    AlertDialog(
      onDismissRequest = { state.eventSink(StoreScreen.Event.DismissErrorDialog) },
      title = { Text("Error") },
      text = { Text("Is empty your TextField") },
      confirmButton = {
        TextButton(onClick = { state.eventSink(StoreScreen.Event.DismissErrorDialog) }) { Text("OK") }
      },
    )
  }
}

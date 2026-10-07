import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.victor7w7r.kmpNatively.App
import com.victor7w7r.kmpNatively.core.di.AppModule
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
	startKoin {
		modules(AppModule)
	}
	ComposeViewport { App() }
}

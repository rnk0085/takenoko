package com.rnk0085.android.takenoko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.rnk0085.android.takenoko.ui.TakenokoAppState
import com.rnk0085.android.takenoko.ui.TakenokoNavHost
import com.rnk0085.android.takenoko.ui.rememberTakenokoAppState
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TakenokoTheme {
                TakenokoApp()
            }
        }
    }
}

@Composable
fun TakenokoApp(
    appState: TakenokoAppState = rememberTakenokoAppState(),
) {
    TakenokoNavHost(
        navController = appState.navController,
        onNavigateToDestination = appState::navigate,
        onBackClick = appState::onBackClick,
    )
}

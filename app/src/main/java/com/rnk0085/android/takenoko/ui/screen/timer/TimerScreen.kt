package com.rnk0085.android.takenoko.ui.screen.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.screen.timer.page.TimerSetPage
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rnk0085.android.takenoko.ui.screen.timer.page.TimerRunningPage
import java.time.Duration

@Composable
fun TimerScreen(
    viewModel: TimerViewModel = viewModel(),
) {
    val uiState: TimerUiState by viewModel.uiState.collectAsState()
    TimerScreen(
        uiState = uiState,
        onStartTimer = viewModel::startTimer
    )
}

@Composable
private fun TimerScreen(
    uiState: TimerUiState,
    onStartTimer: (Duration) -> Unit
) {
    Box {
        // TODO: 自動的に切り替えを行う
        when (uiState.timerState) {
            TimerState.INITIAL -> {
                TimerSetPage(
                    onStartTimer = onStartTimer,
                    timerDuration = uiState.timerDuration,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            TimerState.RUNNING -> {
                TimerRunningPage(
                    timerDuration = uiState.timerDuration,
                    remainingTime = uiState.remainingTimer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            TimerState.PAUSED -> {}
            TimerState.FINISHED -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerScreenPreview() {
    TakenokoTheme {
        TimerScreen()
    }
}

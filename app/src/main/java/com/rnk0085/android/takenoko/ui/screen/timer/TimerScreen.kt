package com.rnk0085.android.takenoko.ui.screen.timer

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.screen.timer.page.TimerRunningPage
import com.rnk0085.android.takenoko.ui.screen.timer.page.TimerSetPage
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.time.Duration

@Composable
fun TimerScreen(
    viewModel: TimerViewModel
) {
    Log.d("debug", "TimerScreen - TimerUiState: ${viewModel.uiState}")
    val uiState: TimerUiState by viewModel.uiState.collectAsState()
    TimerScreen(
        uiState = uiState,
        onSetTimer = viewModel::setTimer,
        onRestartClick = viewModel::startTimer,
        onPauseClick = viewModel::pauseTimer,
        cancelTimer = viewModel::cancelTimer,
        recordStudyTime = viewModel::recordStudyTime
    )
}

@Composable
private fun TimerScreen(
    uiState: TimerUiState,
    onSetTimer: (Duration) -> Unit,
    onRestartClick: () -> Unit,
    onPauseClick: () -> Unit,
    cancelTimer: () -> Unit,
    recordStudyTime: () -> Unit
) {
    Box {
        // TODO: 自動的に切り替えを行う
        when (uiState.timerState) {
            TimerState.INITIAL -> {
                TimerSetPage(
                    onSetTimer = onSetTimer,
                    timerDuration = uiState.settingTime,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            TimerState.FINISHED -> {
                // TODO: タイマー終了後の画面を作成する
                Button(onClick = recordStudyTime) {
                    Text(text = "FINISHED")
                }
            }
            else -> {
                // RUNNING & PAUSED
                TimerRunningPage(
                    settingTime = uiState.settingTime,
                    remainingTime = uiState.remainingTime,
                    timerState = uiState.timerState,
                    onRestartClick = onRestartClick,
                    onPauseClick = onPauseClick,
                    cancelTimer = cancelTimer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerScreenPreview() {
    TakenokoTheme {
        TimerScreen(
            uiState = TimerUiState(),
            onSetTimer = {},
            onRestartClick = {},
            onPauseClick = {},
            cancelTimer = {},
            recordStudyTime = {}
        )
    }
}

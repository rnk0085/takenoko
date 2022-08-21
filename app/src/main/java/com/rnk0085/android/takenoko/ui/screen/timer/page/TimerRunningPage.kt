package com.rnk0085.android.takenoko.ui.screen.timer.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rnk0085.android.takenoko.ui.screen.timer.TimerState
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.time.Duration

@Composable
fun TimerRunningPage(
    timerDuration: Duration,
    remainingTime: Duration,
    timerState: TimerState,
    onRestartClick: () -> Unit,
    onPauseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // 帳尻合わせるためにいれてる
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // タイマー動かしている部分
            Text(
                text = setTimerText(timerDuration),
                color = Color.Gray,
                fontSize = 24.sp
            )

            // TODO: 実際にタイマーを動かす
            Text(
                text = setTimerText(remainingTime),
                fontSize = 62.sp
            )
        }

        item {
            // TODO: ボタンを動的に変更する
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 16.dp),
                onClick = if (timerState == TimerState.RUNNING) onPauseClick else onRestartClick
            ) {
                Text(
                    text = if (timerState == TimerState.RUNNING) "PAUSED" else "RESTART"
                )
            }
        }
    }
}

private fun setTimerText(
    time: Duration
) : String {
    val hours = time.toHours()
    val minutes = time.toMinutes()
    val seconds = (time.toMillis() / 1000) % 60

    val hoursText: String = if (hours in 0..9) "0$hours" else "$hours"
    val minutesText: String = if (minutes in 0..9) "0$minutes" else "$minutes"
    val secondsText: String = if (seconds in 0..9) "0$seconds" else "$seconds"

    return "$hoursText：$minutesText：$secondsText"
}

@Preview(showBackground = true)
@Composable
private fun TimerRunningPagePreview() {
    TakenokoTheme {
        TimerRunningPage(
            timerDuration = Duration.ofMinutes(5),
            remainingTime = Duration.ofMinutes(5),
            timerState = TimerState.RUNNING,
            onRestartClick = {},
            onPauseClick = {}
        )
    }
}

package com.rnk0085.android.takenoko.ui.screen.timer.page

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleEventObserver
import com.rnk0085.android.takenoko.ui.component.TakenokoButton
import com.rnk0085.android.takenoko.ui.component.TakenokoButtonType
import com.rnk0085.android.takenoko.ui.component.TakenokoDialog
import com.rnk0085.android.takenoko.ui.screen.timer.TimerState
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.time.Duration

@Composable
fun TimerRunningPage(
    settingTime: Duration,
    remainingTime: Duration,
    timerState: TimerState,
    openDialog: Boolean,
    showDialog: () -> Unit,
    closeDialog: () -> Unit,
    recordStudyTime: () -> Unit,
    onRestartClick: () -> Unit,
    onPauseClick: () -> Unit,
    cancelTimer: () -> Unit,
    onCancelClick: () -> Unit,
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
                text = setTimerText(settingTime),
                color = Color.Gray,
                fontSize = 24.sp
            )

            // FIXME: タイマーがズレている
            Text(
                text = setTimerText(remainingTime),
                fontSize = 62.sp
            )
        }

        item {
            if (timerState == TimerState.RUNNING) {
                TakenokoButton(
                    buttonType = TakenokoButtonType.Outlined,
                    text = "PAUSED",
                    onClick = onPauseClick,
                    modifier = modifier
                )
            } else {
                TakenokoButton(
                    buttonType = TakenokoButtonType.Normal,
                    text = "RESTART",
                    onClick = onRestartClick,
                    modifier = modifier
                )
            }
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event -> Log.d("debug", "event: $event") }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            cancelTimer()
        }
    }

    // 記録せずに戻ろうとした場合、ダイアログ表示
    BackHandler(enabled = true) {
        showDialog()
    }

    if (openDialog) {
        TakenokoDialog(
            title = "勉強時間を記録しますか？",
            text = "これまでの勉強時間を記録できます",
            onDismissRequest = closeDialog,
            leftButtonLabel = "キャンセル",
            onLeftButtonClick = onCancelClick,
            rightButtonLabel = "記録する",
            onRightButtonClick = recordStudyTime
        )
    }
}

private fun setTimerText(
    time: Duration
): String {
    val hours = time.toHours()
    val minutes = time.toMinutes() % 60
    val seconds = (time.toMillis() / 1000) % 60

    Log.d("debug", "hours: $hours")
    Log.d("debug", "minutes: $minutes")
    Log.d("debug", "seconds: $seconds")

    val hoursText: String = if (hours in 0..9) "0$hours" else "$hours"
    val minutesText: String = if (minutes in 0..9) "0$minutes" else "$minutes"
    val secondsText: String = if (seconds in 0..9) "0$seconds" else "$seconds"

    return "$hoursText:$minutesText:$secondsText"
}

@Preview(showBackground = true)
@Composable
private fun TimerRunningPagePreview() {
    TakenokoTheme {
        TimerRunningPage(
            settingTime = Duration.ofMinutes(5),
            remainingTime = Duration.ofMinutes(5),
            timerState = TimerState.RUNNING,
            openDialog = true,
            showDialog = {},
            closeDialog = {},
            recordStudyTime = {},
            onRestartClick = {},
            onPauseClick = {},
            cancelTimer = {},
            onCancelClick = {}
        )
    }
}

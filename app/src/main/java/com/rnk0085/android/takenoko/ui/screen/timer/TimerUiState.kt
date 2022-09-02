package com.rnk0085.android.takenoko.ui.screen.timer

import java.time.Duration

data class TimerUiState(
    // セットした時間
    val settingTime: Duration = Duration.ofMinutes(5),

    // タイマーの残り時間
    val remainingTime: Duration = settingTime,
    val timerState: TimerState = TimerState.INITIAL,
    val openDialog: Boolean = false,
    val isError: Boolean = false
)

enum class TimerState {
    INITIAL,
    RUNNING,
    PAUSED,
    FINISHED
}

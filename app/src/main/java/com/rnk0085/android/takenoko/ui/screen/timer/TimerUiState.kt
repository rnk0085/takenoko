package com.rnk0085.android.takenoko.ui.screen.timer

import java.time.Duration

data class TimerUiState(
    // セットした時間
    val timerDuration: Duration = Duration.ofMinutes(5),

    // タイマーの残り時間
    val remainingTimer: Duration = timerDuration,
    val timerState: TimerState = TimerState.INITIAL
)

enum class TimerState {
    INITIAL,
    RUNNING,
    PAUSED,
    FINISHED
}

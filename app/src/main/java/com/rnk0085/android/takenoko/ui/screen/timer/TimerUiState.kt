package com.rnk0085.android.takenoko.ui.screen.timer

import java.time.Duration

data class TimerUiState(
    // セットした時間
    val settingTime: Duration,

    // タイマーの残り時間
    val remainingTime: Duration,
    val timerState: TimerState,
    val openDialog: Boolean,
    val isError: Boolean
) {
    companion object {
        val InitialValue = TimerUiState(
            settingTime = Duration.ofMinutes(5),
            remainingTime = Duration.ofMinutes(5),
            timerState = TimerState.INITIAL,
            openDialog = false,
            isError = false
        )
    }
}

enum class TimerState {
    INITIAL,
    RUNNING,
    PAUSED,
    FINISHED
}

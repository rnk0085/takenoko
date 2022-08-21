package com.rnk0085.android.takenoko.ui.screen.timer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.time.Duration

class TimerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState

    fun startTimer(
        timerDuration: Duration
    ) {
        _uiState.update {
            it.copy(
                timerDuration = timerDuration,
                remainingTimer = timerDuration,
                timerState = TimerState.RUNNING
            )
        }
    }
}

package com.rnk0085.android.takenoko.ui.screen.timer

import android.os.CountDownTimer
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
                remainingTimer = timerDuration
            )
        }

        timer.start()
    }

    private var timer: CountDownTimer = object : CountDownTimer(
        _uiState.value.timerDuration.toMillis(),
        COUNTDOWN_INTERVAL
    ) {
        override fun onTick(millisUntilFinished: Long) {
            _uiState.update {
                it.copy(
                    remainingTimer = Duration.ofMillis(millisUntilFinished),
                    timerState = TimerState.RUNNING
                )
            }
        }

        override fun onFinish() {
            _uiState.update {
                it.copy(
                    remainingTimer = Duration.ZERO,
                    timerState = TimerState.FINISHED
                )
            }
        }
    }

    companion object {
        private const val COUNTDOWN_INTERVAL: Long = 1000L
    }
}

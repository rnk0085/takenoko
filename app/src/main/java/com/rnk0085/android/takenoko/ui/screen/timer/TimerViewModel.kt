package com.rnk0085.android.takenoko.ui.screen.timer

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Duration
import java.lang.Exception

class TimerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState

    private var timer: CountDownTimer? = null

    fun startTimer(
        timerDuration: Duration
    ) {
        timer = object : CountDownTimer(
            timerDuration.toMillis(),
            COUNTDOWN_INTERVAL
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _uiState.update {
                    it.copy(
                        remainingTime = Duration.ofMillis(millisUntilFinished),
                        timerState = TimerState.RUNNING
                    )
                }
            }

            override fun onFinish() {
                _uiState.update {
                    it.copy(
                        remainingTime = Duration.ZERO,
                        timerState = TimerState.FINISHED
                    )
                }
            }
        }

        setTimer(timerDuration)
        timer?.start()
    }

    private fun setTimer(
        timerDuration: Duration
    ) {
        _uiState.update {
            it.copy(
                settingTime = timerDuration,
                remainingTime = timerDuration
            )
        }
    }

    companion object {
        private const val COUNTDOWN_INTERVAL: Long = 1000L
    }
}

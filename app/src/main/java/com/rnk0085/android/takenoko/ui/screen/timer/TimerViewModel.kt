package com.rnk0085.android.takenoko.ui.screen.timer

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.time.Duration
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(TimerUiState())
    private val isErrorFlow = MutableStateFlow(false)

    val uiState: StateFlow<TimerUiState> = combine(_uiState, isErrorFlow) { uiState, isError ->
        TimerUiState(
            settingTime = uiState.settingTime,
            remainingTime = uiState.remainingTime,
            timerState = uiState.timerState,
            isError = isError
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        initialValue = TimerUiState()
    )

    private var timer: CountDownTimer? = null
    private var remainingTime: Long? = null

    init {
        Log.d("debug", "TimerViewModel")
    }

    fun startTimer() {
        // FIXME: タイマーがズレている
        timer = object : CountDownTimer(
            remainingTime!!,
            COUNTDOWN_INTERVAL
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _uiState.update {
                    it.copy(
                        remainingTime = Duration.ofMillis(millisUntilFinished),
                        timerState = TimerState.RUNNING
                    )
                }
                remainingTime = millisUntilFinished
                Log.d("debug", "timer: $remainingTime")
            }

            override fun onFinish() {
                _uiState.update {
                    it.copy(
                        remainingTime = Duration.ZERO,
                        timerState = TimerState.FINISHED
                    )
                }
            }
        }.start()
    }

    fun setTimer(
        timerDuration: Duration
    ) {
        remainingTime = timerDuration.toMillis()
        _uiState.update {
            it.copy(
                settingTime = timerDuration,
                remainingTime = timerDuration
            )
        }
        startTimer()
    }

    fun pauseTimer() {
        timer?.cancel()
        _uiState.update {
            it.copy(
                timerState = TimerState.PAUSED
            )
        }
        Log.d("debug", "cancelTimer")
        Log.d("debug", "remainingTime: $remainingTime")
    }

    companion object {
        private const val COUNTDOWN_INTERVAL: Long = 1000L
    }
}

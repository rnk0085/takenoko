package com.rnk0085.android.takenoko

import android.content.Context
import android.os.*
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.rnk0085.android.takenoko.ui.TakenokoAppState
import com.rnk0085.android.takenoko.ui.TakenokoNavHost
import com.rnk0085.android.takenoko.ui.rememberTakenokoAppState
import com.rnk0085.android.takenoko.ui.screen.timer.TimerState
import com.rnk0085.android.takenoko.ui.screen.timer.TimerViewModel
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TimerViewModel by viewModels()
        Log.d("debug", "MainActivity")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Log.d("debug", "Build.VERSION_CODES.S")
            val vibratorManager = applicationContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            val vibrationEffect = VibrationEffect.createWaveform(
                longArrayOf(500L, 500L),
                intArrayOf(VibrationEffect.DEFAULT_AMPLITUDE, 0),
                3
            )
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        } else {
            Log.d("debug", "Not Build.VERSION_CODES.S")
            val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val vibrationEffect = VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(vibrationEffect)
        }

//        lifecycleScope.launch {
//            viewModel.uiState
//                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
//                .collect { uiState ->
//                    if (uiState.timerState == TimerState.FINISHED) {
//                        Log.d("debug", "TimerState.FINISHED")
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                            Log.d("debug", "Build.VERSION_CODES.S")
//                            val vibratorManager = applicationContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
//                            val vibrationEffect = VibrationEffect.createWaveform(
//                                longArrayOf(500L, 500L),
//                                intArrayOf(VibrationEffect.DEFAULT_AMPLITUDE, 0),
//                                3
//                            )
//                            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
//                            vibratorManager.vibrate(combinedVibration)
//                        } else {
//                            Log.d("debug", "Not Build.VERSION_CODES.S")
//                            val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//                            val vibrationEffect = VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE)
//                            vibrator.vibrate(vibrationEffect)
//                        }
//                    }
//
//                    when (uiState.timerState) {
//                        TimerState.FINISHED -> {
//                            Log.d("debug", "FINISHED")
//                        }
//                        TimerState.INITIAL -> {
//                            Log.d("debug", "INITIAL")
//                        }
//                        TimerState.RUNNING -> {
//                            Log.d("debug", "RUNNING")
//                        }
//                        TimerState.PAUSED -> {
//                            Log.d("debug", "PAUSED")
//                        }
//                    }
//                }
//        }

        setContent {
            TakenokoTheme {
                TakenokoApp()
            }
        }
    }
}

@Composable
fun TakenokoApp(
    appState: TakenokoAppState = rememberTakenokoAppState()
) {
    TakenokoNavHost(
        navController = appState.navController,
        onNavigateToDestination = appState::navigate,
        onBackClick = appState::onBackClick
    )
}

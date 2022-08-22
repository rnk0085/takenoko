package com.rnk0085.android.takenoko

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CombinedVibration
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("debug", "MainActivity")

        // TODO: 振動する回数を決める
        val vibrationEffect = VibrationEffect.createWaveform(
            longArrayOf(1000, 300, 1000, 300, 1000, 300),
            intArrayOf(VibrationEffect.DEFAULT_AMPLITUDE, 0, VibrationEffect.DEFAULT_AMPLITUDE, 0, VibrationEffect.DEFAULT_AMPLITUDE, 0),
            -1
        )

        // TODO: 期待通りの動作が出来たら削除する
        // バイブレーション出来るか確認
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Log.d("debug", "Build.VERSION_CODES.S")
            val vibratorManager = applicationContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
            vibratorManager.vibrate(combinedVibration)
        } else {
            Log.d("debug", "Not Build.VERSION_CODES.S")
            val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(vibrationEffect)
        }

        Log.d("debug", "MainActivity")

        // TODO: タイマーが終了した時にバイブレーションするようにしたい
        lifecycleScope.launch {
            viewModel.uiState
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { uiState ->
                    if (uiState.timerState == TimerState.FINISHED) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            Log.d("debug", "Build.VERSION_CODES.S")
                            val vibratorManager = applicationContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)
                            vibratorManager.vibrate(combinedVibration)
                        } else {
                            Log.d("debug", "Not Build.VERSION_CODES.S")
                            val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                            vibrator.vibrate(vibrationEffect)
                        }
                    }

                    when (uiState.timerState) {
                        TimerState.FINISHED -> {
                            Log.d("debug", "FINISHED")
                        }
                        TimerState.INITIAL -> {
                            Log.d("debug", "INITIAL")
                        }
                        TimerState.RUNNING -> {
                            Log.d("debug", "RUNNING")
                        }
                        TimerState.PAUSED -> {
                            Log.d("debug", "PAUSED")
                        }
                    }
                }
        }

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

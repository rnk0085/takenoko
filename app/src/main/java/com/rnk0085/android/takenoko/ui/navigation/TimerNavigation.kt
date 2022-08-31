package com.rnk0085.android.takenoko.ui.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.android.takenoko.ui.screen.timer.TimerScreen
import com.rnk0085.android.takenoko.ui.screen.timer.TimerViewModel

object TimerDestination : TakenokoNavigationDestination {
    override val route: String = "timer_route"
    override val destination: String = "timer_destination"
}

fun NavGraphBuilder.timerGraph(
    onBackClick: () -> Unit
) {
    composable(route = TimerDestination.route) {
        val viewModel = hiltViewModel<TimerViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
        TimerScreen(
            viewModel = viewModel,
            onRecordClick = {
                // TODO: Home画面へストレートに戻りたい
                // 一瞬だけタイマーセット画面が入っている
                onBackClick()
                viewModel.recordStudyTime()
            }
        )
    }
}

package com.rnk0085.android.takenoko.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.android.takenoko.ui.screen.timer.TimerScreen

object TimerDestination : TakenokoNavigationDestination {
    override val route: String = "timer_route"
    override val destination: String = "timer_destination"
}

fun NavGraphBuilder.timerGraph() {
    composable(route = TimerDestination.route) {
        TimerScreen()
    }
}

package com.rnk0085.android.takenoko.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rnk0085.android.takenoko.ui.navigation.HomeDestination
import com.rnk0085.android.takenoko.ui.navigation.TakenokoNavigationDestination
import com.rnk0085.android.takenoko.ui.navigation.TimerDestination
import com.rnk0085.android.takenoko.ui.navigation.homeGraph
import com.rnk0085.android.takenoko.ui.navigation.timerGraph

@Composable
fun TakenokoNavHost(
    navController: NavHostController,
    onNavigateToDestination: (TakenokoNavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = HomeDestination.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            onTimerClick = {
                onNavigateToDestination(
                    TimerDestination, TimerDestination.route,
                )
            }
        )
        timerGraph()
    }
}

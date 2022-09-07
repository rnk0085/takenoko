package com.rnk0085.android.takenoko.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rnk0085.android.takenoko.ui.navigation.HomeDestination
import com.rnk0085.android.takenoko.ui.navigation.TakenokoNavigationDestination
import com.rnk0085.android.takenoko.ui.navigation.TimerDestination
import com.rnk0085.android.takenoko.ui.navigation.TopDestination
import com.rnk0085.android.takenoko.ui.navigation.homeGraph
import com.rnk0085.android.takenoko.ui.navigation.timerGraph
import com.rnk0085.android.takenoko.ui.navigation.topGraph

@Composable
fun TakenokoNavHost(
    navController: NavHostController,
    onNavigateToDestination: (TakenokoNavigationDestination, String) -> Unit,
    onNavigateToDestinationPopUpTo: (TakenokoNavigationDestination, String, TakenokoNavigationDestination) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = TopDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        topGraph(
            navigateToHome = {
                onNavigateToDestinationPopUpTo(
                    HomeDestination,
                    HomeDestination.route,
                    TopDestination
                )
            }
        )
        homeGraph(
            onTimerClick = {
                onNavigateToDestination(
                    TimerDestination,
                    TimerDestination.route
                )
            }
        )
        timerGraph(
            onBackClick = onBackClick
        )
    }
}

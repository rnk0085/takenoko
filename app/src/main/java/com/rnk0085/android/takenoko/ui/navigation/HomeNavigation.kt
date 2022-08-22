package com.rnk0085.android.takenoko.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.android.takenoko.ui.screen.home.HomeScreen

object HomeDestination : TakenokoNavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

fun NavGraphBuilder.homeGraph(
    onTimerClick: () -> Unit
) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            viewModel = hiltViewModel(),
            onTimerClick = onTimerClick
        )
    }
}

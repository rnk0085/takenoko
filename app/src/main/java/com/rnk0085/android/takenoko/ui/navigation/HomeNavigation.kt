package com.rnk0085.android.takenoko.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.android.takenoko.ui.screen.home.HomeScreen

object HomeDestination : TakenokoNavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

fun NavGraphBuilder.homeGraph() {
    composable(route = HomeDestination.route) {
        HomeScreen()
    }
}

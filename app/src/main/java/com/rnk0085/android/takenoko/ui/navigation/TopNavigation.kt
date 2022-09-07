package com.rnk0085.android.takenoko.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.android.takenoko.ui.screen.top.TopScreen

object TopDestination : TakenokoNavigationDestination {
    override val route: String = "top_route"
    override val destination: String = "top_destination"
}

fun NavGraphBuilder.topGraph(
    navigateToHome: () -> Unit
) {
    composable(route = TopDestination.route) {
        TopScreen(
            viewModel = hiltViewModel(),
            navigateToHome = navigateToHome
        )
    }
}

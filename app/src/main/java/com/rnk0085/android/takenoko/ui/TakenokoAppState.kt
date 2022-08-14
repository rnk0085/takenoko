package com.rnk0085.android.takenoko.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.tracing.trace
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rnk0085.android.takenoko.ui.navigation.TakenokoNavigationDestination

@Composable
fun rememberTakenokoAppState(
    navController: NavHostController = rememberNavController()
): TakenokoAppState {
    return remember(navController) {
        TakenokoAppState(navController)
    }
}

class TakenokoAppState(
    val navController: NavHostController
) {
    fun navigate(
        destination: TakenokoNavigationDestination,
        route: String? = null
    ) {
        // https://developer.android.com/jetpack/androidx/releases/tracing#1.1.0
        trace("Navigation: $destination") {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}

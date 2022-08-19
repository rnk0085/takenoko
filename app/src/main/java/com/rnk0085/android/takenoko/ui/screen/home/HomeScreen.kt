package com.rnk0085.android.takenoko.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.screen.home.section.BarGraphSection
import com.rnk0085.android.takenoko.ui.screen.home.section.DateSection
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onTimerClick: () -> Unit
) {
    val uiState: HomeUiState by viewModel.uiState.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onTimerClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                    contentDescription = "TimerSet"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HomeScreen(
                uiState = uiState,
                onTimerClick = onTimerClick
            )
        }
    }
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onTimerClick: () -> Unit
) {
    val dayRecords = uiState.dayRecords.reversed()
    // TODO: Barの数を決める
    val barCount = 8
    val barBottomPadding = 120.dp

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onTimerClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                    contentDescription = "TimerSet"
                )
            }
        }
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 画面サイズを取得
            val screenWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
            val screenHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }

            BarGraphSection(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
                    .padding(top = 16.dp, bottom = barBottomPadding),
                dayRecords = dayRecords,
                barCount = barCount,
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                SideEffect {
                    Log.d("test", "Column")
                }
                DateSection(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = screenHeight - barBottomPadding)
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    dayRecords = dayRecords,
                    barCount = barCount,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRect() {
    TakenokoTheme {
        HomeScreen(
            uiState = HomeUiState.InitialValue,
            onTimerClick = {}
        )
    }
}

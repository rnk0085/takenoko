package com.rnk0085.android.takenoko.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.screen.home.section.BarGraphSection
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
            // TODO: Barの数を決める
            BarGraphSection(
                modifier = Modifier.fillMaxSize().padding(8.dp).padding(bottom = 80.dp),
                dayRecords = uiState.dayRecords.reversed(),
                barCount = 8,
            )
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

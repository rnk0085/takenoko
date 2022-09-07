package com.rnk0085.android.takenoko.ui.screen.top

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.screen.top.section.TopPraiseSection
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TopScreen(
    viewModel: TopViewModel,
    navigateToHome: () -> Unit
) {
   val uiState: TopUiState by viewModel.uiState.collectAsState()
   TopScreen(
       uiState = uiState,
       navigateToHome = navigateToHome
   )
}

@Composable
fun TopScreen(
    uiState: TopUiState,
    navigateToHome: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val screenWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                TopPraiseSection(
                    praiseMessage = uiState.praiseMessage,
                    screenWidth = screenWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = navigateToHome,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(text = "HOMEへ")
                }
            }
        }
    }
}

@Preview
@Composable
fun TopScreenPreview() {
    TakenokoTheme {
        TopScreen(
            uiState = TopUiState.InitialValue,
            navigateToHome = {}
        )
    }
}

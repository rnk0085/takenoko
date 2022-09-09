package com.rnk0085.android.takenoko.ui.screen.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.component.PraiseSection
import com.rnk0085.android.takenoko.ui.component.TakenokoButton
import com.rnk0085.android.takenoko.ui.component.TakenokoButtonType
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

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    PraiseSection(
                        praiseMessage = uiState.praiseMessage,
                        screenWidth = screenWidth,
                        painter = painterResource(id = R.drawable.character2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    TakenokoButton(
                        buttonType = TakenokoButtonType.Normal,
                        text = "はじめる",
                        onClick = navigateToHome,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "これまでの「できた！」",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.studyRecordList) { studyRecord ->
                    DoneListTile(
                        studyRecord = studyRecord,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
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

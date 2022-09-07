package com.rnk0085.android.takenoko.ui.screen.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TopScreen(
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
                TakenokoCharacterImage(
                    screenWidth = screenWidth
                )
            }

            item {
                Button(onClick = navigateToHome) {
                    Text(text = "HOMEへ")
                }
            }
        }
    }
}

@Composable
fun TakenokoCharacterImage(
    screenWidth: Dp
) {
    Image(
        painter = painterResource(id = R.drawable.character2),
        contentDescription = null,
        modifier = Modifier.width(screenWidth / 3)
    )
}

@Preview
@Composable
fun TakenokoCharacterImagePreview() {
    TakenokoTheme {
        TakenokoCharacterImage(
            screenWidth = 200.dp
        )
    }
}

@Preview
@Composable
fun TopScreenPreview() {
    TakenokoTheme {
        TopScreen(
            navigateToHome = {}
        )
    }
}

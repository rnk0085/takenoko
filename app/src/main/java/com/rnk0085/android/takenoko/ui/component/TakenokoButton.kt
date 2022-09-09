package com.rnk0085.android.takenoko.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

enum class TakenokoButtonType {
    Normal,
    Outlined
}

@Composable
fun TakenokoButton(
    buttonType: TakenokoButtonType,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    // TODO: 定数を定義する
    val heightValue = 50.dp

    when (buttonType) {
        TakenokoButtonType.Normal -> {
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(heightValue),
                onClick = onClick,
                enabled = enabled
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.button.copy(
                        fontSize = 18.sp
                    )
                )
            }
        }
        TakenokoButtonType.Outlined -> {
            OutlinedButton(
                modifier = modifier
                    .fillMaxWidth()
                    .height(heightValue),
                onClick = onClick,
                enabled = enabled
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.button.copy(
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun TakenokoButtonPreview() {
    TakenokoTheme {
        TakenokoButton(
            buttonType = TakenokoButtonType.Normal,
            text = "PREVIEW",
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun TakenokoButtonOutlinedPreview() {
    TakenokoTheme {
        TakenokoButton(
            buttonType = TakenokoButtonType.Outlined,
            text = "PREVIEW",
            onClick = {}
        )
    }
}

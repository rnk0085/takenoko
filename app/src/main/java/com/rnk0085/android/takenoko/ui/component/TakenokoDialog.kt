package com.rnk0085.android.takenoko.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TakenokoDialog(
    title: String?,
    text: String?,
    onDismissRequest: () -> Unit,
    leftButtonLabel: String?,
    onLeftButtonClick: () -> Unit,
    rightButtonLabel: String?,
    onRightButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO: スタイルなどを付ける
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            title?.let {
                Text(text = it)
            }
        },
        text = {
            text?.let {
                Text(text = it)
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                leftButtonLabel?.let {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        onClick = onLeftButtonClick
                    ) {
                        Text(text = it)
                    }
                }

                rightButtonLabel?.let {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onRightButtonClick
                    ) {
                        Text(text = it)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TakenokoDialogTwoButtonsPreview() {
    TakenokoTheme {
        TakenokoDialog(
            title = "勉強時間を記録しますか？",
            text = "これまでの勉強時間を記録できます",
            onDismissRequest = {},
            leftButtonLabel = "キャンセル",
            onLeftButtonClick = {},
            rightButtonLabel = "記録する",
            onRightButtonClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TakenokoDialogOnlyOneButtonPreview() {
    TakenokoTheme {
        TakenokoDialog(
            title = "Error",
            text = "通信エラーです",
            onDismissRequest = {},
            leftButtonLabel = null,
            onLeftButtonClick = {},
            rightButtonLabel = "再読み込み",
            onRightButtonClick = {}
        )
    }
}

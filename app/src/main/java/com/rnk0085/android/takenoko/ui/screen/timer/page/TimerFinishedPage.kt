package com.rnk0085.android.takenoko.ui.screen.timer.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TimerFinishedPage(
    onRecordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // 帳尻合わせるためにいれてる
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(text = "作業時間 XX時間XX分")

            Text(text = "お疲れ様でした！")
        }

        item {
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 16.dp),
                onClick = onRecordClick
            ) {
                Text(
                    text = "記録する"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerFinishedPagePreview() {
    TakenokoTheme {
        TimerFinishedPage(
            onRecordClick = {}
        )
    }
}

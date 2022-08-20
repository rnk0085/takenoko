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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TimerRunningPage(
    modifier: Modifier = Modifier,
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
            // タイマー動かしている部分
            Text(
                text = "00:00:00",
                color = Color.Gray,
                fontSize = 24.sp
            )

            // TODO: 実際にタイマーを動かす
            Text(
                text = "00:00:00",
                fontSize = 62.sp
            )
        }

        item {
            // TODO: ボタンを動的に変更する
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 16.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "START")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerRunningPagePreview() {
    TakenokoTheme {
        TimerRunningPage()
    }
}

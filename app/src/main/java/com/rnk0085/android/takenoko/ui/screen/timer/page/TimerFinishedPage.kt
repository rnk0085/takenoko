package com.rnk0085.android.takenoko.ui.screen.timer.page

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.component.PraiseSection
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.time.Duration

@Composable
fun TimerFinishedPage(
    onRecordClick: () -> Unit,
    settingTime: Duration,
    praiseMessage: String,
    screenWidth: Dp,
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
            Text(text = "作業時間")

            Text(
                text = setTimeText(settingTime),
                fontSize = 62.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            PraiseSection(
                praiseMessage = praiseMessage,
                screenWidth = screenWidth,
                painter = painterResource(id = R.drawable.character3),
                modifier = modifier
            )
        }

        item {
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = onRecordClick
            ) {
                Text(
                    text = "「できた！」も記録する"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = onRecordClick
            ) {
                Text(
                    text = "作業時間だけを記録する"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    // TODO: ダイアログ表示
    BackHandler(
        enabled = true,
        onBack = onRecordClick
    )
}

private fun setTimeText(
    time: Duration
): String {
    val hours = time.toHours()
    val minutes = time.toMinutes() % 60

    return if (hours == 0L) "${minutes}分" else if (minutes == 0L) "${hours}時間" else "${hours}時間${minutes}分"
}

@Preview(showBackground = true)
@Composable
private fun TimerFinishedPagePreview1() {
    TakenokoTheme {
        TimerFinishedPage(
            onRecordClick = {},
            settingTime = Duration.ofMinutes(5),
            praiseMessage = "流石！頑張り屋さんだね",
            screenWidth = 360.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerFinishedPagePreview2() {
    TakenokoTheme {
        TimerFinishedPage(
            onRecordClick = {},
            settingTime = Duration.ofHours(1),
            praiseMessage = "流石！頑張り屋さんだね",
            screenWidth = 360.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerFinishedPagePreview3() {
    TakenokoTheme {
        TimerFinishedPage(
            onRecordClick = {},
            settingTime = Duration.ofMinutes(5).plusHours(1),
            praiseMessage = "流石！頑張り屋さんだね",
            screenWidth = 360.dp
        )
    }
}

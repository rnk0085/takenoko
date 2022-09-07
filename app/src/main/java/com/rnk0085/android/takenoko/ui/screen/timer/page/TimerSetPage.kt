package com.rnk0085.android.takenoko.ui.screen.timer.page

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chargemap.compose.numberpicker.FullHours
import com.chargemap.compose.numberpicker.Hours
import com.chargemap.compose.numberpicker.HoursNumberPicker
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.time.Duration

@Composable
fun TimerSetPage(
    onSetTimer: (Duration) -> Unit,
    timerDuration: Duration,
    modifier: Modifier = Modifier
) {
    val nowSetHours = timerDuration.toHours().toInt()
    val nowSetMinutes = timerDuration.toMinutes().toInt()
    var pickerValue by remember { mutableStateOf<Hours>(FullHours(nowSetHours, nowSetMinutes)) }

    Log.d("test", "$nowSetHours : $nowSetMinutes")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            // 帳尻合わせるためにいれてる
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // タイマーセット部分
            HoursNumberPicker(
                modifier = Modifier.padding(horizontal = 8.dp),
                dividersColor = MaterialTheme.colors.secondary,
                value = pickerValue,
                onValueChange = {
                    pickerValue = it
                },
                hoursDivider = {
                    Text(
                        modifier = Modifier.size(24.dp),
                        textAlign = TextAlign.Center,
                        text = ":"
                    )
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { pickerValue = FullHours(0, 5) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "5分")
                }
                Button(
                    onClick = { pickerValue = FullHours(0, 10) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "10分")
                }
                Button(
                    onClick = { pickerValue = FullHours(0, 30) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "30分")
                }
            }
        }

        item {
            // スタートボタンを押すと、タイマーがセットされ動き出す
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 16.dp),
//                colors = ButtonDefaults.textButtonColors(
//                    backgroundColor = Color(0xFFFFA000),
//                    contentColor = Color.Black,
//                    disabledContentColor = Color(0xFFFFFF74)
//                ),
                onClick = {
                    onSetTimer(Duration.ofMinutes(pickerValue.minutes.toLong()).plusHours(pickerValue.hours.toLong()))
                },
                enabled = pickerValue != FullHours(0, 0)
            ) {
                Text(text = "START")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerSetSectionPreview() {
    TakenokoTheme {
        TimerSetPage(
            onSetTimer = {},
            timerDuration = Duration.ofMinutes(5)
        )
    }
}

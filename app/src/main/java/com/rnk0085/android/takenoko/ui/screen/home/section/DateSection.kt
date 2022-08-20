package com.rnk0085.android.takenoko.ui.screen.home.section

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.rnk0085.android.takenoko.domain.model.DayRecord
import com.rnk0085.android.takenoko.ui.screen.home.HomeUiState
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
@Composable
fun DateSection(
    modifier: Modifier = Modifier,
    dayRecords: List<DayRecord>, // 大きい順（最新順）
    barCount: Int = 5,
) {
    val dateFormat = SimpleDateFormat("MM/dd")

    ProvideLayoutDirection(layoutDirection = LayoutDirection.Rtl) {
        // TODO: 各棒グラフの真下に来て欲しい
        // FIXME: 今はただ同間隔開けているだけなので、棒の数が少なかったり数が多すぎると不具合が起きる
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (index in 0 until barCount) {
                Text(text = dateFormat.format(dayRecords[index].date))
            }
        }
    }
}

// https://qiita.com/maxfie1d/items/4c876ce9e0ad589a1089
// TODO: もっと良い方法がありそう
@Composable
private fun ProvideLayoutDirection(
    layoutDirection: LayoutDirection,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides layoutDirection,
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun DateSectionPreview() {
    TakenokoTheme {
        DateSection(dayRecords = HomeUiState.InitialValue.dayRecords.reversed())
    }
}

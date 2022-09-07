package com.rnk0085.android.takenoko.ui.screen.home.section

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.rnk0085.android.takenoko.domain.model.DayRecord

@Composable
fun BarGraphSection(
    modifier: Modifier = Modifier,
    dayRecords: List<DayRecord>, // 大きい順（最新順）
    barCount: Int = 5
) {
    // TODO: アニメーションがかかるのは一度限りになってしまっている
    var animationFlag by remember { mutableStateOf(false) }
    val animateHeight by animateFloatAsState(
        targetValue = if (animationFlag) 1f else 0f,
        animationSpec = tween(durationMillis = 5000, easing = FastOutSlowInEasing)
    )

    // TODO: 処理ここで良いのか…？
    // TODO: テストコードが書きたい…
    Canvas(
        modifier = modifier
    ) {
        animationFlag = true

        val canvasWidth = size.width
        val canvasHeight = size.height

        // リストの中で一番大きい値
        val maxValue = dayRecords[0].totalStudyTime.toFloat()

        // 各Barの横幅
        val barWidth = canvasWidth / (barCount + 1).toFloat()

        // 各Barの間にある間隔のサイズ
        val secondPower = (barCount + 1) * (barCount + 1)
        val xSpace: Float = canvasWidth / secondPower.toFloat()

        val heightLists: List<Float> = List(barCount) { index ->
            calcHeight(
                value = dayRecords[index].totalStudyTime.toFloat(),
                max = maxValue,
                canvasHeight = canvasHeight
            )
        }

        for (index in 0 until barCount) {
            drawRect(
                color = Color(0xFF32CD00),
                topLeft = Offset(
                    x = xSpace * (barCount - index) + barWidth * (barCount - index - 1),
                    y = calcY(canvasHeight, heightLists[index]) + heightLists[index]
                ),
                size = Size(width = barWidth, height = heightLists[index] * -animateHeight)
            )
        }
    }
}

private fun calcHeight(value: Float, max: Float, canvasHeight: Float): Float {
    return (value * canvasHeight) / max
}

private fun calcY(canvasHeight: Float, height: Float): Float {
    return canvasHeight - height
}

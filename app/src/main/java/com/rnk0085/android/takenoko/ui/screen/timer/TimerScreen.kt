package com.rnk0085.android.takenoko.ui.screen.timer

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TimerScreen() {
    Text(text = "TIMER")
}

@Preview(showBackground = true)
@Composable
private fun TimerScreenPreview() {
    TakenokoTheme {
        TimerScreen()
    }
}

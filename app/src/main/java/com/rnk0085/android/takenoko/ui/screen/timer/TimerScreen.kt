package com.rnk0085.android.takenoko.ui.screen.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.ui.screen.timer.page.TimerSetPage
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TimerScreen() {
    Box {
        // TODO: 自動的に切り替えを行う
        TimerSetPage(
            modifier = Modifier.padding(horizontal = 16.dp)
        )

//        TimerRunningPage(
//            modifier = Modifier.padding(horizontal = 16.dp)
//        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerScreenPreview() {
    TakenokoTheme {
        TimerScreen()
    }
}

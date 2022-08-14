package com.rnk0085.android.takenoko.ui.screen.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun HomeScreen() {
    Text(text = "HOME")
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TakenokoTheme {
        HomeScreen()
    }
}

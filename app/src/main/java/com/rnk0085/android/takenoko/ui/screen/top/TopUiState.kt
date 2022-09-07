package com.rnk0085.android.takenoko.ui.screen.top

data class TopUiState (
    val isLoading: Boolean,
    val isError: Boolean,
    val praiseMessage: String,
    // TODO: できた！のリスト
) {
    companion object {
        val InitialValue = TopUiState(
            isLoading = false,
            isError = false,
            praiseMessage = "天才！"
        )
    }
}

package com.rnk0085.android.takenoko.ui.screen.home

import com.rnk0085.android.takenoko.domain.model.DayRecord

data class HomeUiState(
    val dayRecords: List<DayRecord> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        val InitialValue = HomeUiState()
    }
}

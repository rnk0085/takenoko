package com.rnk0085.android.takenoko.ui.screen.top

import com.rnk0085.android.takenoko.domain.model.StudyRecord

data class TopUiState(
    val isLoading: Boolean,
    val isError: Boolean,
    val praiseMessage: String,
    val studyRecordList: List<StudyRecord>
) {
    companion object {
        val InitialValue = TopUiState(
            isLoading = false,
            isError = false,
            praiseMessage = "天才！",
            studyRecordList = emptyList()
        )
    }
}

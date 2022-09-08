package com.rnk0085.android.takenoko.ui.screen.top

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnk0085.android.takenoko.domain.model.StudyRecord
import com.rnk0085.android.takenoko.domain.usecase.top.GetStudyRecordsUseCase
import com.rnk0085.android.takenoko.domain.usecase.top.TopPraiseMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    topPraiseMessageUseCase: TopPraiseMessageUseCase,
    getStudyRecordsUseCase: GetStudyRecordsUseCase
) : ViewModel() {
    // TODO: Loading と Error 処理
    private val isLoadingFlow = MutableStateFlow(false)
    private val isErrorFlow = MutableStateFlow(false)
    private val studyRecordsFlow: Flow<List<StudyRecord>?> = getStudyRecordsUseCase.invoke()

    private val praiseMessage: String

    init {
        // 1度だけ呼び出したいので、init 時に呼び出す
        praiseMessage = topPraiseMessageUseCase.invoke()
    }

    val uiState: StateFlow<TopUiState> = combine(
        isLoadingFlow,
        isErrorFlow,
        studyRecordsFlow
    ) { isLoading, isError, studyRecords ->
        TopUiState(
            isLoading = isLoading,
            isError = isError,
            praiseMessage = praiseMessage,
            studyRecordList = studyRecords ?: emptyList()
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        initialValue = TopUiState.InitialValue
    )
}

package com.rnk0085.android.takenoko.ui.screen.top

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnk0085.android.takenoko.domain.usecase.top.TopPraiseMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    topPraiseMessageUseCase: TopPraiseMessageUseCase
) : ViewModel() {
    private val isLoadingFlow = MutableStateFlow(false)
    private val isErrorFlow = MutableStateFlow(false)

    private val praiseMessage: String

    init {
        // 1度だけ呼び出したいので、init 時に呼び出す
        praiseMessage = topPraiseMessageUseCase.invoke()
    }

    val uiState: StateFlow<TopUiState> = combine(
        isLoadingFlow,
        isErrorFlow
    ) { isLoading, isError ->
        TopUiState(
            isLoading = isLoading,
            isError = isError,
            praiseMessage = praiseMessage
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        initialValue = TopUiState.InitialValue
    )
}

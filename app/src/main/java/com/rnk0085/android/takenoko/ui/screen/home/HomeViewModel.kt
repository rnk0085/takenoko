package com.rnk0085.android.takenoko.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnk0085.android.takenoko.domain.model.DayRecord
import com.rnk0085.android.takenoko.domain.usecase.home.GetDayRecordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getDayRecordsUseCase: GetDayRecordsUseCase
) : ViewModel() {
    private val isLoadingFlow = MutableStateFlow(false)
    private val dayRecordsFlow: Flow<List<DayRecord>?> = getDayRecordsUseCase.invoke()

    val uiState: StateFlow<HomeUiState> = combine(
        dayRecordsFlow,
        isLoadingFlow
    ) { dayRecords, isLoading ->
        HomeUiState(
            dayRecords = dayRecords ?: emptyList(),
            isLoading = isLoading || dayRecords == null,
            isError = false // TODO: エラー処理
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        initialValue = HomeUiState.InitialValue
    )

    init {
        Log.d("debug", "HomeViewModel")
    }
}

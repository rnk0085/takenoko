package com.rnk0085.android.takenoko.ui.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    // TODO: HomeUiState.InitialValue部分の修正
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.InitialValue)
    val uiState: StateFlow<HomeUiState> = _uiState
}

package com.rnk0085.android.takenoko.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    // TODO: HomeUiState.InitialValue部分の修正
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.InitialValue)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        Log.d("debug", "HomeViewModel")
    }
}

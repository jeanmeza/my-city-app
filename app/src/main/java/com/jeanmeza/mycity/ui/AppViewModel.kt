package com.jeanmeza.mycity.ui

import androidx.lifecycle.ViewModel
import com.jeanmeza.mycity.data.local.LocalCategoriesProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        _uiState.value = AppUiState(categories = LocalCategoriesProvider.allCategories)
    }
}
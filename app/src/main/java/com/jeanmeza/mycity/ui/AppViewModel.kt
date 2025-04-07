package com.jeanmeza.mycity.ui

import androidx.lifecycle.ViewModel
import com.jeanmeza.mycity.data.Category
import com.jeanmeza.mycity.data.Recommendation
import com.jeanmeza.mycity.data.local.LocalCategoriesProvider
import com.jeanmeza.mycity.data.local.LocalRecommendationsProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        _uiState.value = AppUiState(categories = LocalCategoriesProvider.allCategories)
    }

    fun loadRecommendations(category: Category) {
        val recommendations = LocalRecommendationsProvider.getAllRecommendations().filter {
            it.category.id == category.id
        }
        _uiState.update {
            it.copy(recommendations = recommendations)
        }
    }

    fun setRecommendation(recommendation: Recommendation) {
        _uiState.update {
            it.copy(selectedRecommendation = recommendation)
        }
    }
}
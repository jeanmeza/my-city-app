package com.jeanmeza.mycity.ui

import com.jeanmeza.mycity.data.Category
import com.jeanmeza.mycity.data.Recommendation

data class AppUiState(
    val categories: List<Category> = emptyList(),
    val recommendations: List<Recommendation> = emptyList(),
    val selectedRecommendation: Recommendation? = null,
)

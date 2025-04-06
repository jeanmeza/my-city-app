package com.jeanmeza.mycity.ui

import com.jeanmeza.mycity.data.Category

data class AppUiState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,
)

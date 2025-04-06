package com.jeanmeza.mycity.data.local

import com.jeanmeza.mycity.data.Recommendation

object LocalRecommendationsProvider {
    fun getAllRecommendations(): List<Recommendation> {
        val categories = LocalCategoriesProvider.allCategories
        // TODO: return list of recommendations
        return emptyList()
    }
}
package com.jeanmeza.mycity.data.local

import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.data.Recommendation

object LocalRecommendationsProvider {
    fun getAllRecommendations(): List<Recommendation> {
        val categories = LocalCategoriesProvider.allCategories
        // TODO: return list of recommendations
        return listOf(
            Recommendation(
                id = 0,
                category = categories[0],
                imageResource = R.drawable.pasticceria_marescotti_cavo,
                name = R.string.pasticceria_marescotti_cavo,
                details = R.string.lorem_ipsum,
            ),
            Recommendation(
                id = 0,
                category = categories[0],
                imageResource = R.drawable.caffe_degli_specchi,
                name = R.string.caffe_degli_specchi,
                details = R.string.lorem_ipsum,
            ),
        )
    }
}
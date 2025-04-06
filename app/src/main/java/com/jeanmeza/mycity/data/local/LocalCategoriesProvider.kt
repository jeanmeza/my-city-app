package com.jeanmeza.mycity.data.local

import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.data.Category

object LocalCategoriesProvider {
    val allCategories = listOf(
        Category(
            id = 1,
            imageResource = R.drawable.coffee_shops,
            name = R.string.coffee_shops
        ),
        Category(
            id = 2,
            imageResource = R.drawable.restaurants,
            name = R.string.restaurants
        ),
        Category(
            id = 3,
            imageResource = R.drawable.kid_friendly_places,
            name = R.string.kid_friendly_places
        ),
        Category(
            id = 4,
            imageResource = R.drawable.parks,
            name = R.string.parks
        ),
        Category(
            id = 5,
            imageResource = R.drawable.shopping_centers,
            name = R.string.shopping_centers
        ),
    )
}
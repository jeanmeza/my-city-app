package com.jeanmeza.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    val category: Category,
    @DrawableRes val imageResource: Int,
    @StringRes val name: Int,
    @StringRes val details: Int,
)

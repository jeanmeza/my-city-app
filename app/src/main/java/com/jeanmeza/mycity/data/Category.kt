package com.jeanmeza.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @DrawableRes val imageResource: Int,
    @StringRes val name: Int,
)

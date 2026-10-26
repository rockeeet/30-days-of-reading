package com.example.a30daysofreading.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ReadingTip(
    val dayNumber: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)

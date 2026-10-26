package com.example.a30daysofreading.data

import com.example.a30daysofreading.R
import com.example.a30daysofreading.model.ReadingTip

object DataSource {
    val readingTips = listOf(
        ReadingTip(1, R.string.day_1_title, R.string.day_1_description, R.drawable.book1),
        ReadingTip(2, R.string.day_2_title, R.string.day_2_description, R.drawable.book2),
        ReadingTip(3, R.string.day_3_title, R.string.day_3_description, R.drawable.book3),
        ReadingTip(4, R.string.day_4_title, R.string.day_4_description, R.drawable.book4),
        ReadingTip(5, R.string.day_5_title, R.string.day_5_description, R.drawable.book5)
    )
}
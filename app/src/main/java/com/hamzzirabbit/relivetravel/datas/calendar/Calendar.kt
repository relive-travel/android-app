package com.hamzzirabbit.relivetravel.datas.calendar

import androidx.annotation.DrawableRes
import java.util.Date

data class Calendar (
    val profile_id: Long,
    val marker_id: Long,
    val calendar_id: Long,
    val calendar_title: String,
    val calendar_date: Date,
    @DrawableRes
    val calendar_image: Int?,
    val calendar_place: String,
    val calendar_address: String,
    val calendar_review: String?,
)
package com.hamzzirabbit.relivetravel.datas.calendar

import androidx.annotation.DrawableRes
import java.time.LocalDate

data class Schedule (
    val calendar_id: Long,
    val schedule_id: Long,
    val marker_id: Long,
    val schedule_date: LocalDate,
    val schedule_place: String?,
    val schedule_address: String?,
    @DrawableRes
    val schedule_image: Int?,
    val schedule_review: String?,
)
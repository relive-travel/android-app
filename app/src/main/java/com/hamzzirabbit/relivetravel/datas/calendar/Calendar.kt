package com.hamzzirabbit.relivetravel.datas.calendar

import java.util.Date

data class Calendar (
    val profile_id: Long,
    val calendar_id: Long,
    val calendar_title: String,
    val calendar_schedule_list: List<Schedule>?,
)
package com.hamzzirabbit.relivetravel.datas.calendar

import android.content.res.Resources
import androidx.annotation.DrawableRes
import java.util.Date

fun calendarList(): List<Calendar> {
    return listOf(
        // calendar_id = 1
        Calendar(
            profile_id = 1,
            calendar_id = 1,
            calendar_title = "일상 여행",
            calendar_schedule_list = null,
        ),
        Calendar(
            profile_id = 1,
            calendar_id = 2,
            calendar_title = "일상 여행",
            calendar_schedule_list = null,
        ),
        Calendar(
            profile_id = 1,
            calendar_id = 3,
            calendar_title = "일상 여행",
            calendar_schedule_list = null,
        ),
    )
}
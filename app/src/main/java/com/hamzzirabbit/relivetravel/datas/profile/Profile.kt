package com.hamzzirabbit.relivetravel.datas.profile

import androidx.annotation.DrawableRes

data class Profile(
    val profile_id: Long,
    val profile_name: String,
    @DrawableRes
    val profile_image: Int?,
    val profile_description: String?
)
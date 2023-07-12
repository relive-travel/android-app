package com.hamzzirabbit.relivetravel.datas.profile

import android.content.res.Resources
import com.hamzzirabbit.relivetravel.R

fun profileList(resources: Resources): List<Profile> {
    return listOf(
        Profile(
            profile_id = 1,
            profile_name = "jisudidoo",
            profile_image = R.drawable.mypage,
            profile_description = "jisudidoo님의 프로필사진"
        ),
        Profile(
            profile_id = 2,
            profile_name = "malangdidoo",
            profile_image = R.drawable.mypage,
            profile_description = "malangdidoo님의 프로필사진"
        ),
        Profile(
            profile_id = 3,
            profile_name = "ddiddoo",
            profile_image = R.drawable.mypage,
            profile_description = "ddiddoo님의 프로필사진"
        ),
        Profile(
            profile_id = 4,
            profile_name = "dindindoo",
            profile_image = R.drawable.mypage,
            profile_description = "dindindoo님의 프로필사진"
        ),
        Profile(
            profile_id = 5,
            profile_name = "doodidoo",
            profile_image = R.drawable.mypage,
            profile_description = "doodidoo님의 프로필사진"
        ),
    )
}
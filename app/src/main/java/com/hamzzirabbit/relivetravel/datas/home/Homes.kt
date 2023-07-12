package com.hamzzirabbit.relivetravel.datas.home

import android.content.res.Resources

fun homeList(): List<Home> {
    return listOf(
        Home(
            profile_id = 1,
            home_id = 1,
            home_description = "사용자님의 HomeFragment입니다"
        ),
        Home(
            profile_id = 2,
            home_id = 2,
            home_description = "malangdidoo님의 HomeFragment입니다"
        ),
        Home(
            profile_id = 3,
            home_id = 3,
            home_description = "ddiddoo님의 HomeFragment입니다"
        ),
        Home(
            profile_id = 4,
            home_id = 4,
            home_description = "dindindoo님의 HomeFragment입니다"
        ),
        Home(
            profile_id = 5,
            home_id = 5,
            home_description = "doodidoo님의 HomeFragment입니다"
        ),
    )
}
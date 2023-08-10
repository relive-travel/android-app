package com.hamzzirabbit.relivetravel.datas.exMarker

import com.naver.maps.geometry.LatLng

fun markerList(): List<ExMarker>? {
    return listOf(
        // calendar_id = 1
        ExMarker(
            profile_id = 1,
            calendar_id = 1,
            marker_id = 1,
            marker_order = 1,
            // 모다모다 서울대입구점
            marker_latLng = LatLng(37.47879573411246, 126.95453273304474),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 1,
            marker_id = 2,
            marker_order = 2,
            // 스타덤PC방 서울대입구점
            marker_latLng = LatLng(37.4793756406231, 126.947206189468),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 1,
            marker_id = 3,
            marker_order = 3,
            // 설빙 서울대입구점
            marker_latLng = LatLng(37.4789922962416, 126.952601584242),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 1,
            marker_id = 4,
            marker_order = 4,
            // 올리브영 관악타운(서울대입구)
            marker_latLng = LatLng(37.48054548716703, 126.95223202665501),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 1,
            marker_id = 5,
            marker_order = 5,
            // 어부사시가 (서울대입구)
            marker_latLng = LatLng(37.47899656141045, 126.95427936155424),
            marker_marker = null
        ),

        /*----- calendar_id = 2 -----*/
        ExMarker(
            profile_id = 1,
            calendar_id = 2,
            marker_id = 6,
            marker_order = 1,
            // 장군집주먹고기 (역곡)
            marker_latLng = LatLng(37.48585080466945, 126.81002275052928),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 2,
            marker_id = 7,
            marker_order = 2,
            // 역곡상상시장 (역곡)
            marker_latLng = LatLng(37.4870559377418, 126.812584125152),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 2,
            marker_id = 8,
            marker_order = 3,
            // 동부센트레빌 201동 (부천 역곡)
            marker_latLng = LatLng(37.48936327219227, 126.80800567151596),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 2,
            marker_id = 9,
            marker_order = 4,
            // 역곡공원
            marker_latLng = LatLng(37.4889425465775, 126.802565686205),
            marker_marker = null
        ),

        /*----- calendar_id = 3 -----*/
        ExMarker(
            profile_id = 1,
            calendar_id = 3,
            marker_id = 10,
            marker_order = 1,
            // 봉순게장 (부천)
            marker_latLng = LatLng(37.50978405789162, 126.81332130586866),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 3,
            marker_id = 11,
            marker_order = 2,
            // 부천식물원
            marker_latLng = LatLng(37.5051566567229, 126.815714656615),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 3,
            marker_id = 12,
            marker_order = 3,
            // 롯데시네마 (서울대입구)
            marker_latLng = LatLng( 37.480973433386254, 126.95215035036244),
            marker_marker = null
        ),
        ExMarker(
            profile_id = 1,
            calendar_id = 3,
            marker_id = 13,
            marker_order = 4,
            // 정숙성 (서울대입구)
            marker_latLng = LatLng(37.47921260561538, 126.95377046767742),
            marker_marker = null
        ),
    )
}
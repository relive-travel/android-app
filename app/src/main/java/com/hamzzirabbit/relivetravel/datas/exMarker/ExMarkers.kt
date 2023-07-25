package com.hamzzirabbit.relivetravel.datas.exMarker

import com.naver.maps.geometry.LatLng

fun markerList(): List<ExMarker>? {
    return listOf(
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
    )
}
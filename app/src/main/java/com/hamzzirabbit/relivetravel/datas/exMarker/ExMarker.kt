package com.hamzzirabbit.relivetravel.datas.exMarker

import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker

data class ExMarker (
    val profile_id: Long,
    val calendar_id: Long,
    val marker_id: Long,
    val marker_order: Long,
    val marker_latLng: LatLng,
    var marker_marker: Marker?
)
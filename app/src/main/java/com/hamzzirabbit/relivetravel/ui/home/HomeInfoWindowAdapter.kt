package com.hamzzirabbit.relivetravel.ui.home

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.hamzzirabbit.relivetravel.R
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.InfoWindow.ViewAdapter

class HomeInfoWindowAdapter(layoutInflater: LayoutInflater): ViewAdapter() {
    private val _layoutInflater = layoutInflater

    override fun getView(infoWindow: InfoWindow): View {
        var homeInfoWindow: View = _layoutInflater.inflate(R.layout.home_info_window, null)
        var infoWindowTitle: TextView = homeInfoWindow.findViewById<TextView>(R.id.home_info_window_title)
        infoWindowTitle.text = "지수 여행"
        return homeInfoWindow
    }
}
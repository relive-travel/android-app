package com.hamzzirabbit.relivetravel.ui.home

import android.view.View
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker

class HomeInfoWindowAdapter(infoWindowView: View): InfoWindowAdapter {

    private var _infoWindowView: View = infoWindowView

    override fun getInfoWindow(marker: Marker): View? {
        return _infoWindowView
    }

    override fun getInfoContents(marker: Marker): View? {
        return null
    }
}
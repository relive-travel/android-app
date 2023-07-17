package com.hamzzirabbit.relivetravel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.databinding.FragmentHomeBinding

class HomeFragment: Fragment(), OnMapReadyCallback{
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    private lateinit var googleMapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        googleMapView = _homeBinding?.homeGoogleMapView as MapView
        googleMapView.onCreate(savedInstanceState)
        googleMapView.getMapAsync(this)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val sydneyLatLng = LatLng(-34.0, 151.0)
        val sydney = googleMap.addMarker(
            MarkerOptions()
                .position(sydneyLatLng))

        googleMap.setInfoWindowAdapter(
            HomeInfoWindowAdapter(
                infoWindowView = layoutInflater.inflate(R.layout.home_info_window, null),
            )
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydneyLatLng))
    }
    override fun onStart() {
        super.onStart()
        googleMapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        googleMapView.onStop()
    }

    override fun onResume() {
        super.onResume()
        googleMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        googleMapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        googleMapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        googleMapView.onDestroy()
    }
}
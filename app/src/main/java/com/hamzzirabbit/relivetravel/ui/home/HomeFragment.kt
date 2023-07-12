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
import com.hamzzirabbit.relivetravel.databinding.FragmentHomeBinding
import com.hamzzirabbit.relivetravel.datas.home.Home
import com.hamzzirabbit.relivetravel.datas.home.homeList

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

        googleMapView = _homeBinding!!.homeGoogleMapView as MapView
        googleMapView.onCreate(savedInstanceState)
        googleMapView.getMapAsync(this)

        val profileId = arguments?.getLong("profile_id")
        if (profileId != null) {
            val homeInfo: Home = homeList().find { it.home_id == profileId }!!
            _homeBinding!!.homeTextView.text = homeInfo.home_description
        }
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(
            MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
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
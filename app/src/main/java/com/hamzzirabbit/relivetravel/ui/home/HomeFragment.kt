package com.hamzzirabbit.relivetravel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.databinding.FragmentHomeBinding
import com.hamzzirabbit.relivetravel.databinding.HomeInfoWindowBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.InfoWindow

class HomeFragment: Fragment(), OnMapReadyCallback {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!
    private val _homeInfoWindowBinding: HomeInfoWindowBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val naverMapFragment = childFragmentManager.findFragmentById(R.id.naver_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                childFragmentManager.beginTransaction().add(R.id.naver_map, it).commit()
            }
        naverMapFragment.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onMapReady(naverMap: NaverMap) {
        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(37.566, 126.978),  10.0)) // 카메라 위치 (위도,경도,줌)
            .mapType(NaverMap.MapType.Basic)    //지도 유형
            .enabledLayerGroups(NaverMap.LAYER_GROUP_TRANSIT)   //대중교통 표시

        MapFragment.newInstance(options)

        naverMap.isIndoorEnabled = true

        setMarkers(naverMap)
    }
    private fun setMarkers(naverMap: NaverMap) {
        val infoWindow = InfoWindow()

        infoWindow.adapter = HomeInfoWindowAdapter(
            layoutInflater,
        )

        val marker = Marker()
        marker.position = LatLng(37.5670135, 126.9783740)
        marker.map = naverMap
        marker.setOnClickListener {
            infoWindow.open(marker)
            true
        }

        naverMap.setOnMapClickListener { pointF, latLng ->
            infoWindow.close()
        }
    }

}
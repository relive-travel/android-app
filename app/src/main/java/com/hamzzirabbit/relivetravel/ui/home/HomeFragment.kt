package com.hamzzirabbit.relivetravel.ui.home

import android.graphics.Color
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.databinding.FragmentHomeBinding
import com.hamzzirabbit.relivetravel.datas.exMarker.ExMarker
import com.hamzzirabbit.relivetravel.datas.exMarker.markerList
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.PathOverlay

class HomeFragment: Fragment(), OnMapReadyCallback {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    private val infoWindowContoroller: LinearLayout by lazy {
        _homeBinding!!.homeNaverMapInfoWindowController
    }

    private var naverMapController: NaverMap? = null

    private lateinit var exMarkers: List<ExMarker>
    private var markerSelected: ExMarker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val naverMapFragment = childFragmentManager.findFragmentById(R.id.home_naver_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                childFragmentManager.beginTransaction().add(R.id.home_naver_map, it).commit()
            }
        exMarkers = markerList() as List<ExMarker>

        naverMapFragment.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _homeBinding!!.homeInfoWindowPrev.setOnClickListener {
            val prevMarker = exMarkers.find {
                it.marker_order == (markerSelected?.marker_order?.minus(1) ?: -1)
            }
            prevMarker?.marker_marker?.performClick()
        }
        _homeBinding!!.homeInfoWindowNext.setOnClickListener {
            val nextMarker = exMarkers.find {
                it.marker_order == (markerSelected?.marker_order?.plus(1) ?: -1)
            }
            nextMarker?.marker_marker?.performClick()
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(37.566, 126.978),  10.0)) // 카메라 위치 (위도,경도,줌)
            .mapType(NaverMap.MapType.Basic)    //지도 유형
            .enabledLayerGroups(NaverMap.LAYER_GROUP_TRANSIT)   //대중교통 표시
        MapFragment.newInstance(options)
        naverMap.isIndoorEnabled = true
        naverMapController = naverMap

        val uiSettings = naverMap.uiSettings
        uiSettings.isZoomControlEnabled = false

        setMarkers()
    }
    private fun setMarkers() {
        val infoWindow = InfoWindow()

        infoWindow.adapter = HomeInfoWindowAdapter(
            layoutInflater,
        )

        for (exMarker: ExMarker in exMarkers) {
            val marker = Marker()
            marker.position = exMarker.marker_latLng
            marker.map = naverMapController
            marker.setOnClickListener {
                val cameraUpdate = CameraUpdate.scrollTo(marker.position)
                    .animate(CameraAnimation.Easing)
                    .pivot(PointF(0.5f, 0.85f))
                naverMapController!!.moveCamera(cameraUpdate)

                infoWindowContoroller.isVisible = true
                infoWindow.open(marker)

                if (exMarker.calendar_id != markerSelected?.calendar_id) {
                    setMarkerPath(exMarker.calendar_id)
                }
                markerSelected = exMarker

                true
            }
            exMarker.marker_marker = marker
        }

        naverMapController!!.setOnMapClickListener { pointF, latLng ->
            infoWindowContoroller.isInvisible = true
            infoWindow.close()
        }

        // 카메라 이동: 서울대입구역 2호선 37.4812845080678 126.952713197762
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.4812845080678, 126.952713197762))
        naverMapController!!.moveCamera(cameraUpdate)
    }

    private fun setMarkerPath(calendar_id: Long) {
        val path = PathOverlay()
        val markerList: List<LatLng> = exMarkers.filter { it.calendar_id == calendar_id }.sortedBy { it.marker_order }.map { it.marker_latLng }
        path.coords = markerList
        path.color = Color.parseColor("#EB898E")
        path.width = 15
        path.outlineWidth = 0
        path.map = naverMapController
    }

}
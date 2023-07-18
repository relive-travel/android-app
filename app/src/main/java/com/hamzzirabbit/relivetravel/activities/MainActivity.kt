package com.hamzzirabbit.relivetravel.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.databinding.ActivityMainBinding

import com.hamzzirabbit.relivetravel.datas.profile.Profile
import com.hamzzirabbit.relivetravel.ui.calendar.CalendarFragment
import com.hamzzirabbit.relivetravel.ui.feed.FeedFragment
import com.hamzzirabbit.relivetravel.ui.home.HomeFragment
import com.hamzzirabbit.relivetravel.ui.profile.ProfileAdapter
import com.hamzzirabbit.relivetravel.ui.profile.ProfileListViewModel
import com.hamzzirabbit.relivetravel.ui.profile.ProfileListViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private var mainBinding: ActivityMainBinding? = null
    private val _mainBinding get() = mainBinding!!

    private val newMainActivityRequestCode = 1
    private val profileListViewModel by viewModels<ProfileListViewModel> {
        ProfileListViewModelFactory(this)
    }

    private val bottomNavigationView: BottomNavigationView by lazy {
        _mainBinding.btNav
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_mainBinding.root)

        /*----- tool bar -----*/
        setSupportActionBar(_mainBinding.mainActionBar)
        // left 버튼 추가 여부
        // supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        // left 버튼 이미지 설정
        // supportActionBar!!.setHomeAsUpIndicator(R.drawable.logo_name)
        // Title 제거
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        /*----- profile list -----*/
        val profileAdapter = ProfileAdapter{ profile: Profile -> adapterOnClick(profile) }
        val recyclerView: RecyclerView = _mainBinding.recyclerProfileView
        recyclerView.adapter = profileAdapter

        profileListViewModel.profileLiveData.observe(this) {
            it?.let {
                profileAdapter.submitList(it as MutableList<Profile>)
            }
        }

        /*----- bottom navigation -----*/
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_container, HomeFragment(), "home").commit()
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bt_nav_home -> {
                    replaceFragment(R.id.main_fragment_container, HomeFragment(), "home")
                    true
                }
                R.id.bt_nav_calendar -> {
                    replaceFragment(R.id.main_fragment_container, CalendarFragment(), "calendar")
                    true
                }
                R.id.bt_nav_feed -> {
                    replaceFragment(R.id.main_fragment_container, FeedFragment(), "feed")
                    true
                }
                R.id.bt_nav_add_travel -> {
                    true
                }
                R.id.bt_nav_mypage -> {
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_nav_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun adapterOnClick(profile: Profile) {
        val bundle = Bundle()
        bundle.putLong("profile_id", profile.profile_id)
        when(bottomNavigationView.selectedItemId) {
            R.id.bt_nav_home -> {
                val homeFragment = HomeFragment()
                homeFragment.arguments = bundle
                replaceFragment(R.id.main_fragment_container, homeFragment, "home")
            }
            R.id.bt_nav_calendar -> {
                val calendarFragment = CalendarFragment()
                calendarFragment.arguments = bundle
                replaceFragment(R.id.main_fragment_container, calendarFragment, "calendar")
            }
            R.id.bt_nav_feed -> {
                val feedFragment = FeedFragment()
                feedFragment.arguments = bundle
                replaceFragment(R.id.main_fragment_container, feedFragment, "feed")
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == newMainActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            data?.let { item ->
//                val profileName = item.getStringExtra("profile_name")
//                val profileDescription = item.getStringExtra("profile_description")
//
//                profileListViewModel.insertProfile(profileName, profileDescription)
//            }
//        }
//    }

    private fun replaceFragment(fragment_id: Int, fragment: Fragment, name: String) {
        supportFragmentManager.commit {
            replace(fragment_id, fragment)
            setReorderingAllowed(true)
            addToBackStack(name)
        }
    }
}
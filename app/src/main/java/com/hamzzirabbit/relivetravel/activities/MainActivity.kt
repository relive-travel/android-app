package com.hamzzirabbit.relivetravel.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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

        /*----- navigation -----*/
//        val interactionFragment = supportFragmentManager.findFragmentById(R.id.interaction_fragment) as NavHostFragment
//        navController = interactionFragment.navController

        /*----- bottom navigation -----*/
        supportFragmentManager.beginTransaction().add(R.id.interaction_fragment, HomeFragment(), "home").commit()
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bt_nav_home -> {
                    replaceFragment(R.id.interaction_fragment, HomeFragment(), "home")
                    true
                }
                R.id.bt_nav_calendar -> {
                    replaceFragment(R.id.interaction_fragment, CalendarFragment(), "calendar")
                    true
                }
                R.id.bt_nav_feed -> {
                    replaceFragment(R.id.interaction_fragment, FeedFragment(), "feed")
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.setOnItemReselectedListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_nav_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun adapterOnClick(profile: Profile) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newMainActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let { item ->
                val profileName = item.getStringExtra("name")
                val profileDescription = item.getStringExtra("description")

                profileListViewModel.insertProfile(profileName, profileDescription)
            }
        }
    }

    private fun replaceFragment(fragment_id: Int, fragment: Fragment, name: String) {
        supportFragmentManager.commit {
            replace(fragment_id, fragment)
            setReorderingAllowed(true)
            addToBackStack(name)
        }
    }
}
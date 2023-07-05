package com.hamzzirabbit.relivetravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.hamzzirabbit.relivetravel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainBinding: ActivityMainBinding? = null
    private val _mainBinding get() = mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(_mainBinding.root)
        setSupportActionBar(_mainBinding.mainActionBar)
        // left 버튼 추가 여부
        // supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        // left 버튼 이미지 설정
        // supportActionBar!!.setHomeAsUpIndicator(R.drawable.logo_name)
        // Title 제거
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_nav_items, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
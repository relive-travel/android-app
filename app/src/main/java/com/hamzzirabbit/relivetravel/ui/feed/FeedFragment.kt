package com.hamzzirabbit.relivetravel.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hamzzirabbit.relivetravel.databinding.FragmentFeedBinding

class FeedFragment: Fragment() {
    private var _feedBinding: FragmentFeedBinding? = null
    private val feedBinding get() = _feedBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _feedBinding = FragmentFeedBinding.inflate(inflater, container, false)
        return feedBinding.root
    }
}
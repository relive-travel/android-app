package com.hamzzirabbit.relivetravel.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hamzzirabbit.relivetravel.databinding.FragmentCalendarBinding

class CalendarFragment: Fragment() {
    private var _calendarBinding: FragmentCalendarBinding? = null
    private val calendarBinding get() = _calendarBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _calendarBinding = FragmentCalendarBinding.inflate(inflater, container, false)
        return calendarBinding.root
    }
}
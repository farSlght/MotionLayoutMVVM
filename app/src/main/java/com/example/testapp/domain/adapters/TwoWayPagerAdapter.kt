package com.example.testapp.domain.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.testapp.view.dailyplan.DailyPlanFragment

class TwoWayPagerAdapter(fm: FragmentManager/*, private val vmProvider: () -> GameGridTabViewModel*/) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        return DailyPlanFragment.newInstance(p0)
    }

    override fun getCount(): Int = 300
}
package com.sembozdemir.autoscout24.photo

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PhotoPagerAdapter(
        fragmentManager: FragmentManager,
        private val imageUrls: List<String?>?,
        private val zoomEnabled: Boolean = true
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = PhotoFragment.newInstance(imageUrls?.get(position), zoomEnabled)

    override fun getCount() = imageUrls?.size ?: 1
}
package com.sembozdemir.autoscout24.detail

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ImagePagerAdapter(
        fragmentManager: FragmentManager,
        private val imageUrls: List<String?>?
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = ImagePageFragment.newInstance(imageUrls?.get(position))

    override fun getCount() = imageUrls?.size ?: 1
}
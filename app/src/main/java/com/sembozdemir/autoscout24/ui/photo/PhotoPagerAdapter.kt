package com.sembozdemir.autoscout24.ui.photo

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PhotoPagerAdapter(
        fragmentManager: FragmentManager,
        private val imageUrls: List<String?>?
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = PhotoFragment.newInstance(imageUrls?.get(position))

    override fun getCount() = imageUrls?.size ?: 1
}
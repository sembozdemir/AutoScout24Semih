package com.sembozdemir.autoscout24.photo

import android.os.Bundle
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseSimpleActivity
import kotlinx.android.synthetic.main.activity_full_screen_photos.*

class FullScreenPhotosActivity : BaseSimpleActivity() {

    companion object {
        const val EXTRA_IMAGE_URLS = "images"
        const val EXTRA_CURRENT_ITEM = "currentItem"
    }

    private val imageUrls by lazy { intent.getStringArrayListExtra(EXTRA_IMAGE_URLS) }

    private val currentItem by lazy { intent.getIntExtra(EXTRA_CURRENT_ITEM, 0) }

    override fun getLayoutResId() = R.layout.activity_full_screen_photos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreenPhotosViewPager.adapter = PhotoPagerAdapter(supportFragmentManager, imageUrls)
        fullScreenCircleIndicator.setViewPager(fullScreenPhotosViewPager)

        fullScreenPhotosViewPager.currentItem = currentItem
    }
}
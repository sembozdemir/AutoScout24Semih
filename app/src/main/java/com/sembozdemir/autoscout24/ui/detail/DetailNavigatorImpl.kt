package com.sembozdemir.autoscout24.ui.detail

import android.app.Activity
import com.sembozdemir.autoscout24.ui.photo.FullScreenPhotosActivity
import org.jetbrains.anko.startActivity

class DetailNavigatorImpl : DetailNavigator {

    private var activity: Activity? = null

    override fun bind(activity: Activity) {
        this.activity = activity
    }

    override fun unbind() {
        activity = null
    }

    override fun navigateFullScreenPhoto(imageUrls: List<String>, currentItemIndex: Int) {
        activity?.startActivity<FullScreenPhotosActivity>(
                FullScreenPhotosActivity.EXTRA_IMAGE_URLS to imageUrls,
                FullScreenPhotosActivity.EXTRA_CURRENT_ITEM to currentItemIndex
        )
    }
}
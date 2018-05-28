package com.sembozdemir.autoscout24.ui.detail

import com.sembozdemir.autoscout24.core.Navigator

interface DetailNavigator : Navigator {

    fun navigateFullScreenPhoto(imageUrls: List<String>, currentItemIndex: Int)
}
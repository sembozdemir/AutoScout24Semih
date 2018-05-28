package com.sembozdemir.autoscout24.ui.detail

import com.sembozdemir.autoscout24.core.BaseView

interface DetailView : BaseView {
    fun showFullScreenMode(imageUrls: List<String>, currentItemIndex: Int)
}
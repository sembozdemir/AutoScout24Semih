package com.sembozdemir.autoscout24.ui.detail

import com.sembozdemir.autoscout24.core.BasePresenter

class DetailPresenter : BasePresenter<DetailView>() {

    fun onFullScreenModeWanted(imageUrls: List<String>, currentItemIndex: Int) {
        ifViewAttached { it.showFullScreenMode(imageUrls, currentItemIndex) }
    }
}
package com.sembozdemir.autoscout24.photo

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent

class PhotoViewPager(context: Context) : ViewPager(context) {

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return try {
            super.onInterceptTouchEvent(ev)
        } catch (e: IllegalArgumentException) {
            //uncomment if you really want to see these errors
            //e.printStackTrace();
            false
        }

    }
}
package com.sembozdemir.autoscout24.core

import android.app.Activity

interface Navigator {

    fun bind(activity: Activity)

    fun unbind()
}
package com.sembozdemir.autoscout24.ui.list

import android.app.Activity
import android.view.View

interface ListNavigator {

    fun bind(activity: Activity)

    fun unbind()

    fun navigateToDetail(vehicleItem: VehicleItem, sharedView: View)
}
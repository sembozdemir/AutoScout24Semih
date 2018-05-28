package com.sembozdemir.autoscout24.ui.list

import android.view.View
import com.sembozdemir.autoscout24.core.Navigator
import com.sembozdemir.autoscout24.network.model.Vehicle

interface ListNavigator : Navigator {

    fun navigateToDetail(vehicle: Vehicle, sharedView: View)
}
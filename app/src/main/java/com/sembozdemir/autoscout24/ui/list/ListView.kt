package com.sembozdemir.autoscout24.ui.list

import android.view.View
import com.sembozdemir.autoscout24.core.BaseView

interface ListView : BaseView {
    fun showVehicles(vehicles: List<VehicleListItem>)
    fun showError()
    fun navigateToDetail(vehicleItem: VehicleItem, sharedView: View)
}
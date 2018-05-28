package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.core.BaseView

interface ListView : BaseView {
    fun showVehicles(vehicles: List<VehicleListItem>)
    fun showError()
}
package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.network.model.Vehicle

interface VehicleListItemConverter {

    fun getVehicleListItem(position: Int, vehicle: Vehicle): VehicleListItem
}
package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.network.model.Vehicle

sealed class VehicleListItem
data class VehicleItem(val vehicle: Vehicle) : VehicleListItem()
data class AdItem(val imageUrl: String) : VehicleListItem()
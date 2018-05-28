package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.util.AdProvider

class VehicleListItemConverterImpl(private val adProvider: AdProvider) : VehicleListItemConverter {

    companion object {
        const val REM_VALUE = 3
    }

    override fun getVehicleListItem(position: Int, vehicle: Vehicle): VehicleListItem {

        return if (position != 0 && position.rem(REM_VALUE) == 0) { // every third item (except first item)
            AdItem(adProvider.nextAdImageUrl())
        } else {
            VehicleItem(vehicle)
        }
    }

}
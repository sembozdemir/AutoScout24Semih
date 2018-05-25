package com.sembozdemir.autoscout24.list

import com.sembozdemir.autoscout24.core.BasePresenter
import com.sembozdemir.autoscout24.network.VehicleRepository
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class ListPresenter(
        private val vehicleRepository: VehicleRepository
) : BasePresenter<ListView>() {
    fun loadVehicles() {
        vehicleRepository.fetchVehicles()
                .subscribeBy(
                        onSuccess = { vehicles ->
                            if (vehicles.isNotEmpty()) {
                                ifViewAttached { it.showFirstVehicleName(vehicles.first().make.orEmpty()) }
                            }
                        },
                        onError = {
                            Timber.e(it)
                        }
                )
    }

}
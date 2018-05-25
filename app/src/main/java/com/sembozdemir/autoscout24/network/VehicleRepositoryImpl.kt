package com.sembozdemir.autoscout24.network

import com.sembozdemir.autoscout24.network.model.Vehicle
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class VehicleRepositoryImpl(private val vehicleService: VehicleService) : VehicleRepository {

    override fun fetchVehicles(): Single<List<Vehicle>> {
        return vehicleService.getVehicles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
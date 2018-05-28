package com.sembozdemir.autoscout24.repository

import com.sembozdemir.autoscout24.network.model.Vehicle
import io.reactivex.Single

interface VehicleRepository {

    fun fetchVehicles(): Single<List<Vehicle>>

    fun fetchVehiclesFreshly(): Single<List<Vehicle>>
}
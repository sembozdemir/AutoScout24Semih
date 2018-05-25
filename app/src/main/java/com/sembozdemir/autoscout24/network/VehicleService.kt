package com.sembozdemir.autoscout24.network

import com.sembozdemir.autoscout24.network.model.Vehicle
import io.reactivex.Single
import retrofit2.http.GET

interface VehicleService {

    @GET("/")
    fun getVehicles(): Single<List<Vehicle>>
}
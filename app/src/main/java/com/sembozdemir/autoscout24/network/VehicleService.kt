package com.sembozdemir.autoscout24.network

import com.sembozdemir.autoscout24.network.model.Vehicle
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface VehicleService {

    @GET
    fun getVehicles(@Url dummyEndpoint: String = ""): Single<List<Vehicle>>
}
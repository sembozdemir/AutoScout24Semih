package com.sembozdemir.autoscout24.network.model

import android.os.Parcelable
import com.sembozdemir.autoscout24.persistance.entity.VehicleEntity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Vehicle(

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "images")
        val images: List<Image?>? = null,

        @Json(name = "price")
        val price: Int? = null,

        @Json(name = "fuel")
        val fuel: String? = null,

        @Json(name = "description")
        val description: String? = null,

        @Json(name = "model")
        val model: String? = null,

        @Json(name = "make")
        val make: String? = null,

        @Json(name = "firstRegistration")
        val firstRegistration: String? = null,

        @Json(name = "mileage")
        val mileage: Int? = null
) : Parcelable

fun Vehicle.getFullName() = "$make $model"

fun Vehicle.toVehicleEntity() = VehicleEntity(
        id,
        images?.map { it?.url },
        price,
        fuel,
        description,
        model,
        make,
        firstRegistration,
        mileage
)
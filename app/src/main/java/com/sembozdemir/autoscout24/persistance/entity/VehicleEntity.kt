package com.sembozdemir.autoscout24.persistance.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.sembozdemir.autoscout24.network.model.Image
import com.sembozdemir.autoscout24.network.model.Vehicle

@Entity(tableName = "vehicles")
data class VehicleEntity(

        @PrimaryKey
        @ColumnInfo(name = "id")
        var id: Int? = null,

        @ColumnInfo(name = "imageUrls")
        var imageUrls: List<String?>? = null,

        @ColumnInfo(name = "price")
        var price: Int? = null,

        @ColumnInfo(name = "fuel")
        var fuel: String? = null,

        @ColumnInfo(name = "description")
        var description: String? = null,

        @ColumnInfo(name = "model")
        var model: String? = null,

        @ColumnInfo(name = "make")
        var make: String? = null,

        @ColumnInfo(name = "firstRegistration")
        var firstRegistration: String? = null,

        @ColumnInfo(name = "mileage")
        var mileage: Int? = null

)

fun VehicleEntity.toVehicle() = Vehicle(
        id,
        imageUrls?.map { Image(it) },
        price,
        fuel,
        description,
        model,
        make,
        firstRegistration,
        mileage
)
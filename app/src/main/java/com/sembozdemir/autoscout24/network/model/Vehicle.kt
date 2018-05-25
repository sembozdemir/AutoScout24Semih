package com.sembozdemir.autoscout24.network.model

import com.squareup.moshi.Json

data class Vehicle(

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

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "make")
        val make: String? = null,

        @Json(name = "firstRegistration")
        val firstRegistration: String? = null,

        @Json(name = "mileage")
        val mileage: Int? = null
)
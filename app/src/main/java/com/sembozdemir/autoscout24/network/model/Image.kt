package com.sembozdemir.autoscout24.network.model

import com.squareup.moshi.Json

data class Image(

        @Json(name = "url")
        val url: String? = null
)
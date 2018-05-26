package com.sembozdemir.autoscout24.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(

        @Json(name = "url")
        val url: String? = null
) : Parcelable
package com.sembozdemir.autoscout24.persistance

import android.arch.persistence.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class ImageUrlsTypeConverter {

    companion object {
        @TypeConverter
        @JvmStatic
        fun jsonToStringList(json: String?): List<String?>? {

            if (json == null) return emptyList()

            val moshi = Moshi.Builder().build()
            val type = Types.newParameterizedType(List::class.java, String::class.java)
            val jsonAdapter = moshi.adapter<List<String?>?>(type)

            return jsonAdapter.fromJson(json)
        }

        @TypeConverter
        @JvmStatic
        fun stringListToJson(list: List<String?>?): String {
            val moshi = Moshi.Builder().build()
            val type = Types.newParameterizedType(List::class.java, String::class.java)
            val jsonAdapter = moshi.adapter<List<String?>?>(type)
            return jsonAdapter.toJson(list)
        }
    }

}
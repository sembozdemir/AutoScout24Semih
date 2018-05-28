package com.sembozdemir.autoscout24.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.sembozdemir.autoscout24.persistance.entity.VehicleEntity

@Database(entities = [VehicleEntity::class], version = 1)
@TypeConverters(ImageUrlsTypeConverter::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}
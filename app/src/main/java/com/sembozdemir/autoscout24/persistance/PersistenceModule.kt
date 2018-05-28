package com.sembozdemir.autoscout24.persistance

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideVehicleDatabase(context: Context) = Room.databaseBuilder(context, VehicleDatabase::class.java, "vehicle_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideVehicleDao(database: VehicleDatabase) = database.vehicleDao()
}
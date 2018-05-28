package com.sembozdemir.autoscout24.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.sembozdemir.autoscout24.persistance.entity.VehicleEntity
import io.reactivex.Single

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicles")
    fun getVehicles(): Single<List<VehicleEntity>>

    @Insert
    fun insertVehicles(vehicles: List<VehicleEntity>?)

    @Delete
    fun deleteVehicles(vehicles: List<VehicleEntity>)
}
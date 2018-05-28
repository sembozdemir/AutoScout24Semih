package com.sembozdemir.autoscout24.repository

import com.sembozdemir.autoscout24.network.VehicleService
import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.network.model.toVehicleEntity
import com.sembozdemir.autoscout24.persistance.VehicleDao
import com.sembozdemir.autoscout24.persistance.entity.toVehicle
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class VehicleRepositoryImpl(
        private val vehicleService: VehicleService,
        private val vehicleDao: VehicleDao
) : VehicleRepository {

    override fun fetchVehicles(): Single<List<Vehicle>> {
        return getVehiclesFromDb()
                .flatMap { if (it.isEmpty()) getVehiclesFromRemote() else Single.just(it) }
    }

    override fun fetchVehiclesFreshly(): Single<List<Vehicle>> {
        return vehicleService.getVehicles()
                .doOnSuccess { freshVehicles ->
                    Timber.d("Dispatching ${freshVehicles.size} items from API...")
                    vehicleDao.getVehicles()
                            .subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.io())
                            .subscribeBy {
                                vehicleDao.deleteVehicles(it)
                                Timber.d("Deleted all items from DB...")
                                storeVehicles(freshVehicles)
                            }
                }
    }

    private fun getVehiclesFromRemote(): Single<List<Vehicle>> {
        return vehicleService.getVehicles()
                .doOnSuccess {
                    Timber.d("Dispatching ${it.size} items from API...")
                    storeVehicles(it)
                }
    }

    private fun getVehiclesFromDb(): Single<List<Vehicle>> {
        return vehicleDao.getVehicles()
                .doOnSuccess {
                    Timber.d("Dispatching ${it.size} items from DB...")
                }
                .map { vehicleEntities -> vehicleEntities.map { it.toVehicle() } }
    }

    private fun storeVehicles(vehicles: List<Vehicle>?) {
        vehicleDao.insertVehicles(vehicles?.map { it.toVehicleEntity() })
        Timber.d("Inserted ${vehicles?.size} items from API in DB...")
    }

}
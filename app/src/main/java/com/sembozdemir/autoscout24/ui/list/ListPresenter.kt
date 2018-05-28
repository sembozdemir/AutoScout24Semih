package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.core.BasePresenter
import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.repository.VehicleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ListPresenter(
        private val vehicleRepository: VehicleRepository,
        private val vehicleListItemConverter: VehicleListItemConverter
) : BasePresenter<ListView>() {

    private val compositeDisposable = CompositeDisposable()

    fun loadVehicles() {
        vehicleRepository.fetchVehicles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { insertAds(it) }
                .subscribeBy(
                        onSuccess = { vehicleListItems ->
                            if (vehicleListItems.isNotEmpty()) {
                                ifViewAttached { it.showVehicles(vehicleListItems) }
                            }
                        },
                        onError = {
                            Timber.e(it)
                        }
                ).also { compositeDisposable.add(it) }
    }

    fun refreshVehicles() {
        vehicleRepository.fetchVehiclesFreshly()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { insertAds(it) }
                .subscribeBy(
                        onSuccess = { vehicleListItems ->
                            if (vehicleListItems.isNotEmpty()) {
                                ifViewAttached { it.showVehicles(vehicleListItems) }
                            }
                        },
                        onError = {
                            Timber.e(it)
                        }
                ).also { compositeDisposable.add(it) }
    }

    private fun insertAds(vehicles: List<Vehicle>): List<VehicleListItem> {

        val vehicleListItems = mutableListOf<VehicleListItem>()

        vehicles.forEachIndexed { index, vehicle ->
            val vehicleListItem = vehicleListItemConverter.getVehicleListItem(index, vehicle)
            vehicleListItems.add(vehicleListItem)

            if (vehicleListItem is AdItem) {
                vehicleListItems.add(VehicleItem(vehicle))
            }
        }

        return vehicleListItems
    }

    override fun detachView() {
        compositeDisposable.clear()
        super.detachView()
    }

}
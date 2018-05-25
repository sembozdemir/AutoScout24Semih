package com.sembozdemir.autoscout24.list

import com.sembozdemir.autoscout24.network.VehicleRepository
import com.sembozdemir.autoscout24.network.VehicleRepositoryImpl
import com.sembozdemir.autoscout24.network.VehicleService
import dagger.Module
import dagger.Provides

@Module
class ListActivityModule {

    @Provides
    fun provideListPresenter(vehicleRepository: VehicleRepository) = ListPresenter(vehicleRepository)

    @Provides
    fun provideVehicleRepository(vehicleService: VehicleService): VehicleRepository {
        return VehicleRepositoryImpl(vehicleService)
    }
}
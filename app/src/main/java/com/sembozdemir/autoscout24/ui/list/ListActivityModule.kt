package com.sembozdemir.autoscout24.ui.list

import com.sembozdemir.autoscout24.network.VehicleService
import com.sembozdemir.autoscout24.persistance.VehicleDao
import com.sembozdemir.autoscout24.repository.VehicleRepository
import com.sembozdemir.autoscout24.repository.VehicleRepositoryImpl
import com.sembozdemir.autoscout24.util.AdProvider
import com.sembozdemir.autoscout24.util.AdProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ListActivityModule {

    @Provides
    fun provideListPresenter(
            vehicleRepository: VehicleRepository,
            vehicleListItemConverter: VehicleListItemConverter
    ) = ListPresenter(vehicleRepository, vehicleListItemConverter)

    @Provides
    fun provideVehicleRepository(vehicleService: VehicleService, vehicleDao: VehicleDao): VehicleRepository {
        return VehicleRepositoryImpl(vehicleService, vehicleDao)
    }

    @Provides
    fun provideListNavigator(): ListNavigator = ListNavigatorImpl()

    @Provides
    fun provideAdProvider(): AdProvider = AdProviderImpl()

    @Provides
    fun providerVehicleListItemConverter(adProvider: AdProvider): VehicleListItemConverter {
        return VehicleListItemConverterImpl(adProvider)
    }
}
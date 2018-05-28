package com.sembozdemir.autoscout24.core.injection

import android.app.Application
import com.sembozdemir.autoscout24.App
import com.sembozdemir.autoscout24.network.NetworkModule
import com.sembozdemir.autoscout24.persistance.PersistenceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    NetworkModule::class,
    PersistenceModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}
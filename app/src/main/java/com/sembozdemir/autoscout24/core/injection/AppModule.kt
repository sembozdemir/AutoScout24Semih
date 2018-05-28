package com.sembozdemir.autoscout24.core.injection

import android.content.Context
import com.sembozdemir.autoscout24.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context = application.applicationContext
}
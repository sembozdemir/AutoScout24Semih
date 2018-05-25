package com.sembozdemir.autoscout24.list

import dagger.Module
import dagger.Provides

@Module
class ListActivityModule {

    @Provides
    fun provideListPresenter() = ListPresenter()
}
package com.sembozdemir.autoscout24.detail

import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    fun provideDetailPresenter(): DetailPresenter = DetailPresenter()

}
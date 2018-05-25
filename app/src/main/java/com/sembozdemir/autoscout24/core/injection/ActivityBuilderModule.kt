package com.sembozdemir.autoscout24.core.injection

import com.sembozdemir.autoscout24.list.ListActivity
import com.sembozdemir.autoscout24.list.ListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ListActivityModule::class])
    abstract fun bindListActivity(): ListActivity
}
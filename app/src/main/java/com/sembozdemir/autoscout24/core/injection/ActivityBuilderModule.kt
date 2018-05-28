package com.sembozdemir.autoscout24.core.injection

import com.sembozdemir.autoscout24.ui.detail.DetailActivity
import com.sembozdemir.autoscout24.ui.detail.DetailActivityModule
import com.sembozdemir.autoscout24.ui.list.ListActivity
import com.sembozdemir.autoscout24.ui.list.ListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ListActivityModule::class])
    abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity
}
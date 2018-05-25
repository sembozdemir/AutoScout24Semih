package com.sembozdemir.autoscout24.core

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

abstract class BasePresenter<V: BaseView> : MvpBasePresenter<V>()
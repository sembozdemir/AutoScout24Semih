package com.sembozdemir.autoscout24.core

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : MvpActivity<V, P>(), BaseView {

    @LayoutRes
    abstract fun getLayoutResId(): Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResId())
    }
}
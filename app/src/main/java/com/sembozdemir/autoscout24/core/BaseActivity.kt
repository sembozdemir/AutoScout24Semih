package com.sembozdemir.autoscout24.core

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.sembozdemir.autoscout24.R
import dagger.android.AndroidInjection
import org.jetbrains.anko.appcompat.v7.navigationIconResource

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : MvpActivity<V, P>(), BaseView {

    @LayoutRes
    abstract fun getLayoutResId(): Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResId())
    }

    fun enableHomeAsUp(toolbar: Toolbar) {
        toolbar.navigationIconResource = R.drawable.ic_back
        toolbar.setNavigationOnClickListener { finish() }
    }
}
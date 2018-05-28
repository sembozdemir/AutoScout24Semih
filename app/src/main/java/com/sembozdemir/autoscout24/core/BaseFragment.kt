package com.sembozdemir.autoscout24.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpFragment<V, P>(), BaseView {

    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

}
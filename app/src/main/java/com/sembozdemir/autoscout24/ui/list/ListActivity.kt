package com.sembozdemir.autoscout24.ui.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseActivity
import com.sembozdemir.autoscout24.extensions.action
import com.sembozdemir.autoscout24.extensions.snack
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.toast
import javax.inject.Inject

class ListActivity : BaseActivity<ListView, ListPresenter>(), ListView {

    private val vehiclesRecyclerAdapter = VehiclesRecyclerAdapter(mutableListOf())

    @Inject
    lateinit var listNavigator: ListNavigator

    @Inject
    lateinit var listPresenter: ListPresenter

    override fun createPresenter() = listPresenter

    override fun getLayoutResId() = R.layout.activity_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listNavigator.bind(this)

        setupSwipeRefreshLayout()
        setupRecyclerView()

        listSwipeRefreshLayout.isRefreshing = true
        presenter.loadVehicles()
    }

    override fun onDestroy() {
        listNavigator.unbind()
        super.onDestroy()
    }

    private fun setupSwipeRefreshLayout() {
        listSwipeRefreshLayout.onRefresh {
            presenter.refreshVehicles()
        }
    }

    private fun setupRecyclerView() {

        vehiclesRecyclerAdapter.onVehicleItemClick { vehicleItem, view ->
            presenter.onVehicleItemSelected(vehicleItem, view)
        }

        vehiclesRecyclerAdapter.onAdItemClick {
            toast("Ad is clicked.")
        }

        with(listRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiclesRecyclerAdapter
        }
    }

    override fun navigateToDetail(vehicleItem: VehicleItem, sharedView: View) {
        listNavigator.navigateToDetail(vehicleItem.vehicle, sharedView)
    }

    override fun showVehicles(vehicles: List<VehicleListItem>) {
        listSwipeRefreshLayout.isRefreshing = false
        vehiclesRecyclerAdapter.updateItems(vehicles)
    }

    override fun showError() {
        listSwipeRefreshLayout.isRefreshing = false
        listLinearLayoutRoot.snack(R.string.general_error, Snackbar.LENGTH_INDEFINITE) {
            action(R.string.retry) {
                listSwipeRefreshLayout.isRefreshing = true
                presenter.refreshVehicles()
            }
        }
    }
}
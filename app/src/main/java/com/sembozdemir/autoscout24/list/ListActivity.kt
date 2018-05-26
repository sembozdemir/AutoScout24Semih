package com.sembozdemir.autoscout24.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseActivity
import com.sembozdemir.autoscout24.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class ListActivity : BaseActivity<ListView, ListPresenter>(), ListView {

    private val vehiclesRecyclerAdapter = VehiclesRecyclerAdapter(mutableListOf())

    @Inject
    lateinit var listPresenter: ListPresenter

    override fun createPresenter() = listPresenter

    override fun getLayoutResId() = R.layout.activity_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupRecyclerView()

        presenter.loadVehicles()
    }

    private fun setupRecyclerView() {

        vehiclesRecyclerAdapter.onItemClick { vehicleListItem ->
            when (vehicleListItem) {
                is VehicleItem -> navigateToDetail(vehicleListItem)
                is AdItem -> toast("Ad is clicked.")
            }
        }

        with(listRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiclesRecyclerAdapter
        }
    }

    private fun navigateToDetail(vehicleItem: VehicleItem) {
        startActivity<DetailActivity>(
                DetailActivity.EXTRA_VEHICLE to vehicleItem.vehicle
        )
    }

    override fun showVehicles(vehicles: List<VehicleListItem>) {
        vehiclesRecyclerAdapter.updateItems(vehicles)
    }
}
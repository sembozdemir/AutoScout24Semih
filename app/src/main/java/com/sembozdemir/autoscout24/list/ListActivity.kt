package com.sembozdemir.autoscout24.list

import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseActivity
import com.sembozdemir.autoscout24.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.intentFor
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

        vehiclesRecyclerAdapter.onVehicleItemClick { vehicleItem, view ->
            navigateToDetail(vehicleItem, view)
        }

        vehiclesRecyclerAdapter.onAdItemClick {
            toast("Ad is clicked.")
        }

        with(listRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiclesRecyclerAdapter
        }
    }

    private fun navigateToDetail(vehicleItem: VehicleItem, view: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, view, getString(R.string.transition_detail_photo)
        )

        val intent = intentFor<DetailActivity>(
                DetailActivity.EXTRA_VEHICLE to vehicleItem.vehicle
        )

        ActivityCompat.startActivity(this, intent, options.toBundle())
    }

    override fun showVehicles(vehicles: List<VehicleListItem>) {
        vehiclesRecyclerAdapter.updateItems(vehicles)
    }
}
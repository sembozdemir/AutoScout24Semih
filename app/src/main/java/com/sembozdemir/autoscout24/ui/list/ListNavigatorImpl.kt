package com.sembozdemir.autoscout24.ui.list

import android.app.Activity
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.ui.detail.DetailActivity
import org.jetbrains.anko.intentFor

class ListNavigatorImpl : ListNavigator {

    private var activity: Activity? = null

    override fun bind(activity: Activity) {
        this.activity = activity
    }

    override fun unbind() {
        activity = null
    }

    override fun navigateToDetail(vehicle: Vehicle, sharedView: View) {
        activity?.let {

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    it, sharedView, it.getString(R.string.transition_detail_photo)
            )

            val intent = it.intentFor<DetailActivity>(
                    DetailActivity.EXTRA_VEHICLE to vehicle
            )

            ActivityCompat.startActivity(it, intent, options.toBundle())
        }
    }
}
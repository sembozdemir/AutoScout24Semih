package com.sembozdemir.autoscout24.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.extensions.asFormattedAmount
import com.sembozdemir.autoscout24.extensions.orDash
import com.sembozdemir.autoscout24.extensions.setImageUrl
import com.sembozdemir.autoscout24.network.model.getFullName
import kotlinx.android.synthetic.main.list_item_vehicle.view.*

class VehicleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(vehicleItem: VehicleItem) {
        val vehicle = vehicleItem.vehicle
        with(itemView) {
            listItemVehicleTextViewTitle.text = vehicle.getFullName()
            listItemVehicleTextViewFuel.text = vehicle.fuel
            listItemVehicleTextViewPrice.text = context.getString(R.string.euro_currency_format,
                    vehicle.price?.asFormattedAmount().orDash())
            listItemVehicleImageView.setImageUrl(vehicle.images?.firstOrNull()?.url.orEmpty()) {
                fit()
                centerCrop()
                placeholder(R.drawable.ic_placeholder_vehicle)
                error(R.drawable.ic_placeholder_vehicle)
            }
        }
    }
}
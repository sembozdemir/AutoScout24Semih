package com.sembozdemir.autoscout24.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.extensions.autoNotify
import com.sembozdemir.autoscout24.extensions.inflate
import kotlinx.android.synthetic.main.list_item_vehicle.view.*

class VehiclesRecyclerAdapter(
        private val vehicleList: MutableList<VehicleListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onVehicleItemClickFunc: (vehicleItem: VehicleItem, view: View) -> Unit = { _, _ ->  }
    private var onAdItemClickFunc: (adItem: AdItem) -> Unit = { }

    companion object {
        private const val VEHICLE_ITEM_TYPE = 0
        private const val AD_ITEM_TYPE = 1
    }

    override fun getItemCount() = vehicleList.size

    override fun getItemViewType(position: Int) = when (vehicleList[position]) {
        is VehicleItem -> VEHICLE_ITEM_TYPE
        is AdItem -> AD_ITEM_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VEHICLE_ITEM_TYPE -> VehicleItemViewHolder(parent.inflate(R.layout.list_item_vehicle)).apply {
            itemView.setOnClickListener {
                onVehicleItemClickFunc(vehicleList[adapterPosition] as VehicleItem, it.listItemVehicleImageView)
            }
        }
        AD_ITEM_TYPE -> AdItemViewHolder(parent.inflate(R.layout.list_item_ad)).apply {
            itemView.setOnClickListener {
                onAdItemClickFunc(vehicleList[adapterPosition] as AdItem)
            }
        }
        else -> throw IllegalStateException("View type could not be matched.")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VehicleItemViewHolder -> holder.bind(vehicleList[position] as VehicleItem)
            is AdItemViewHolder -> holder.bind(vehicleList[position] as AdItem)
        }
    }

    fun onVehicleItemClick(func: (vehicleListItem: VehicleItem, view: View) -> Unit) {
        onVehicleItemClickFunc = func
    }

    fun onAdItemClick(func: (adItem: AdItem) -> Unit) {
        onAdItemClickFunc = func
    }

    fun updateItems(vehicles: List<VehicleListItem>) {
        val oldItems = vehicleList.toList()
        vehicleList.clear()
        vehicleList.addAll(vehicles)

        autoNotify(oldItems, vehicleList) { oldItem, newItem ->

            when {
                oldItem is VehicleItem && newItem is VehicleItem -> {
                    return@autoNotify oldItem.vehicle.id == newItem.vehicle.id
                }
                oldItem is AdItem && newItem is AdItem -> {
                    return@autoNotify oldItem.imageUrl == newItem.imageUrl
                }
                else -> return@autoNotify false
            }
        }
    }
}
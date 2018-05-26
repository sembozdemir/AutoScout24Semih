package com.sembozdemir.autoscout24.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.extensions.autoNotify
import com.sembozdemir.autoscout24.extensions.inflate

class VehiclesRecyclerAdapter(
        private val vehicleList: MutableList<VehicleListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClickFunc: (vehicleListItem: VehicleListItem) -> Unit = {}

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
        VEHICLE_ITEM_TYPE -> VehicleItemViewHolder(parent.inflate(R.layout.list_item_vehicle))
        AD_ITEM_TYPE -> AdItemViewHolder(parent.inflate(R.layout.list_item_ad))
        else -> throw IllegalStateException("View type could not be matched.")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VehicleItemViewHolder -> holder.bind(vehicleList[position] as VehicleItem)
            is AdItemViewHolder -> holder.bind(vehicleList[position] as AdItem)
        }

        holder.itemView.setOnClickListener { onItemClickFunc(vehicleList[position]) }
    }

    fun onItemClick(func: (vehicleListItem: VehicleListItem) -> Unit) {
        onItemClickFunc = func
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
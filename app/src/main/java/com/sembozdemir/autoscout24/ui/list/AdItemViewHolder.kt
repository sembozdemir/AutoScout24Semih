package com.sembozdemir.autoscout24.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.sembozdemir.autoscout24.extensions.setImageUrl
import kotlinx.android.synthetic.main.list_item_ad.view.*

class AdItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(adItem: AdItem) {
        with(itemView) {
            listItemAdImageView.setImageUrl(adItem.imageUrl)
        }
    }
}
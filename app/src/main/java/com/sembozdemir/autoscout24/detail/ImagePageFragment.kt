package com.sembozdemir.autoscout24.detail

import android.os.Bundle
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseSimpleFragment
import com.sembozdemir.autoscout24.extensions.setImageUrl
import kotlinx.android.synthetic.main.fragment_image_page.*
import org.jetbrains.anko.bundleOf

class ImagePageFragment : BaseSimpleFragment() {

    companion object {

        private const val KEY_IMAGE_URL = "imageUrl"

        fun newInstance(imageUrl: String?) = ImagePageFragment().apply {
            arguments = bundleOf(KEY_IMAGE_URL to imageUrl)
        }
    }

    private val imageUrl by lazy { arguments?.getString(KEY_IMAGE_URL) }

    override fun getLayoutResId() = R.layout.fragment_image_page

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageUrl?.let {
            imagePageImageView.setImageUrl(it) {
                fit()
                centerCrop()
            }
        } ?: imagePageImageView.setImageResource(R.drawable.ic_placeholder_vehicle)


    }
}
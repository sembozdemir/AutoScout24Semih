package com.sembozdemir.autoscout24.ui.photo

import android.os.Bundle
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseSimpleFragment
import com.sembozdemir.autoscout24.extensions.setImageUrl
import kotlinx.android.synthetic.main.fragment_photo.*
import org.jetbrains.anko.bundleOf

class PhotoFragment : BaseSimpleFragment() {

    companion object {

        private const val KEY_IMAGE_URL = "imageUrl"

        fun newInstance(imageUrl: String?) = PhotoFragment().apply {
            arguments = bundleOf(
                    KEY_IMAGE_URL to imageUrl
            )
        }
    }


    private val imageUrl by lazy { arguments?.getString(KEY_IMAGE_URL) }

    override fun getLayoutResId() = R.layout.fragment_photo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageUrl?.let {
            photoView.setImageUrl(it) {
                fit()
                centerInside()
            }
        }

    }
}
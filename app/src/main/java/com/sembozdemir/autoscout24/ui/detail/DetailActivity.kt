package com.sembozdemir.autoscout24.ui.detail

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseSimpleActivity
import com.sembozdemir.autoscout24.extensions.asFormattedAmount
import com.sembozdemir.autoscout24.extensions.orDash
import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.network.model.getFullName
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import javax.inject.Inject

class DetailActivity : BaseSimpleActivity() {

    companion object {
        const val EXTRA_VEHICLE = "vehicle"
    }

    private val vehicle by lazy { intent.getParcelableExtra<Vehicle>(EXTRA_VEHICLE) }

    @Inject
    lateinit var detailNavigator: DetailNavigator

    override fun getLayoutResId() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailNavigator.bind(this)

        enableHomeAsUp(detailToolbar)

        initPhotoViewPager()

        detailTextViewTitle.text = vehicle.getFullName()
        detailTextViewFuel.text = vehicle.fuel.orDash()
        detailTextViewMileage.text = vehicle.mileage.toString().orDash()
        detailTextViewFirstRegistration.text = vehicle.firstRegistration.orDash()
        detailTextViewPrice.text = getString(R.string.euro_currency_format, vehicle.price?.asFormattedAmount().orDash())
        detailTextViewDescription.text = vehicle.description

    }

    override fun onDestroy() {
        detailNavigator.unbind()
        super.onDestroy()
    }

    private fun enableHomeAsUp(toolbar: Toolbar) {
        toolbar.navigationIconResource = R.drawable.ic_back
        toolbar.setNavigationOnClickListener { supportFinishAfterTransition() }
    }

    private fun initPhotoViewPager() {
        val imageUrls = vehicle.images?.map { it?.url.orEmpty() }.orEmpty()
        detailViewPagerPhotos.adapter = ImagePagerAdapter(supportFragmentManager, imageUrls)
        detailCircleIndicator.setViewPager(detailViewPagerPhotos)

        vehicle.images?.let {
            detailImageViewFullScreen.visibility = View.VISIBLE
            detailImageViewFullScreen.setOnClickListener {
                detailNavigator.navigateFullScreenPhoto(imageUrls, detailViewPagerPhotos.currentItem)
            }
        }
    }
}
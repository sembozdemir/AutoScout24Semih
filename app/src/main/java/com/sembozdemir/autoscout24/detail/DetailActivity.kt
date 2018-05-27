package com.sembozdemir.autoscout24.detail

import android.os.Bundle
import com.sembozdemir.autoscout24.R
import com.sembozdemir.autoscout24.core.BaseActivity
import com.sembozdemir.autoscout24.extensions.orDash
import com.sembozdemir.autoscout24.network.model.Vehicle
import com.sembozdemir.autoscout24.network.model.getFullName
import com.sembozdemir.autoscout24.photo.PhotoPagerAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity<DetailView, DetailPresenter>(), DetailView {

    companion object {
        const val EXTRA_VEHICLE = "vehicle"
    }

    private val vehicle by lazy { intent.getParcelableExtra<Vehicle>(EXTRA_VEHICLE) }

    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun createPresenter() = detailPresenter

    override fun getLayoutResId() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableHomeAsUp(detailToolbar)

        initPhotoViewPager()

        detailTextViewTitle.text = vehicle.getFullName()
        detailTextViewFuel.text = vehicle.fuel.orDash()
        detailTextViewMileage.text = vehicle.mileage.toString().orDash()
        detailTextViewFirstRegistration.text = vehicle.firstRegistration.orDash()
        detailTextViewPrice.text = vehicle.price.toString() // TODO: format price amount
        detailTextViewDescription.text = vehicle.description

    }

    private fun initPhotoViewPager() {
        val imageUrls = vehicle.images?.map { it?.url }
        detailViewPagerPhotos.adapter = PhotoPagerAdapter(supportFragmentManager, imageUrls, zoomEnabled = false)
        detailCircleIndicator.setViewPager(detailViewPagerPhotos)
    }
}
package com.sembozdemir.autoscout24.util

import java.util.Random

class AdProviderImpl : AdProvider {

    private val adImageUrls = arrayOf(
            "https://dummyimage.com/1000x400/607d8b/ffffff&text=Ad+is+here",
            "https://dummyimage.com/1000x400/607d8b/ffffff&text=They+will+look+here",
            "https://dummyimage.com/1000x400/607d8b/ffffff&text=This+is+ad",
            "https://dummyimage.com/1000x400/607d8b/ffffff&text=Sponsored"
    )

    override fun nextAdImageUrl(): String {
        val random = Random()
        return adImageUrls[random.nextInt(adImageUrls.size)]
    }

}
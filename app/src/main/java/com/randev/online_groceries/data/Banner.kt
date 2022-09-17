package com.randev.online_groceries.data

import com.randev.online_groceries.R

/**
 * @author Raihan Arman
 * @date 17/09/22
 */
data class Banner(
    val id: Int,
    val image: Int,
)

object DummyDataBanner {
    fun bannerList(): List<Banner> = listOf(
        Banner(1, R.drawable.banner),
        Banner(2, R.drawable.banner),
        Banner(3, R.drawable.banner),
    )
}
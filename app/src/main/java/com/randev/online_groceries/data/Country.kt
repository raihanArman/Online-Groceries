package com.randev.online_groceries.data

import com.randev.online_groceries.R

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

data class Country(
    val id: Int,
    val code: String,
    val name: String,
    val flag: Int
)

object DummyDataCountry {
    fun countryList(): List<Country> = listOf(
        Country(
            id = 1,
            code = "+62",
            name = "Indonesia",
            flag = R.drawable.flag
        ),
        Country(
            id = 2,
            code = "+1",
            name = "America",
            flag = R.drawable.america
        ),
        Country(
            id = 3,
            code = "+65",
            name = "Singapore",
            flag = R.drawable.singapore
        ),
    )
}
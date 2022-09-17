package com.randev.online_groceries.data

import com.randev.online_groceries.R

/**
 * @author Raihan Arman
 * @date 17/09/22
 */
data class Product(
    val id: Int,
    val name: String,
    val image: Int,
    val unit: String,
    val price: String,
    val description: String,
    val nutrition: String,
    val review: Float
)

object DummyDataProduct {
    fun productList(): List<Product> = listOf(
        Product(
            id = 1,
            name = "Banana",
            image = R.drawable.banana,
            unit = "7pcs",
            price = "\$4.99",
            description = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            nutrition = "100gr",
            review = 4.5f
        ),
        Product(
            id = 1,
            name = "Tomato",
            image = R.drawable.tomato,
            unit = "1pcs",
            price = "\$4.99",
            description = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            nutrition = "100gr",
            review = 4.5f
        ),
        Product(
            id = 1,
            name = "Beef",
            image = R.drawable.beef,
            unit = "2pcs",
            price = "\$4.99",
            description = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            nutrition = "100gr",
            review = 4.5f
        ),
    )
}

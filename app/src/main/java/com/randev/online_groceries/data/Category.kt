package com.randev.online_groceries.data

import androidx.compose.ui.graphics.Color
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.theme.ColorCategory1
import com.randev.online_groceries.ui.theme.PrimaryColor

/**
 * @author Raihan Arman
 * @date 17/09/22
 */
data class Category(
    val id: Int,
    val name: String,
    val image: Int,
    val color: Color
)

object DummyDataCategory {
    fun categoryList(): List<Category> = listOf(
        Category(
            id = 1,
            name = "Pulses",
            image = R.drawable.pulses,
            color = ColorCategory1.copy(alpha = 0.4f)
        ),
        Category(
            id = 2,
            name = "Rice",
            image = R.drawable.rice,
            color = PrimaryColor.copy(alpha = 0.4f)
        )
    )
}

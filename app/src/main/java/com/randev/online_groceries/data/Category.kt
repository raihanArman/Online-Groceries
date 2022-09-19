package com.randev.online_groceries.data

import androidx.compose.ui.graphics.Color
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.theme.ColorCategory1
import com.randev.online_groceries.ui.theme.ColorCategory2
import com.randev.online_groceries.ui.theme.ColorCategory3
import com.randev.online_groceries.ui.theme.ColorCategory4
import com.randev.online_groceries.ui.theme.ColorCategory5
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

object DummyDataExplore {
    fun exploreList(): List<Category> = listOf(
        Category(
            id = 1,
            name = "Frash Fruits & Vegetable",
            image = R.drawable.fruit,
            color = PrimaryColor
        ),
        Category(
            id = 2,
            name = "Cooking Oil & Ghee",
            image = R.drawable.cook,
            color = ColorCategory1
        ),
        Category(
            id = 3,
            name = "Meat & Fish",
            image = R.drawable.meat,
            color = ColorCategory2
        ),
        Category(
            id = 4,
            name = "Bakery & Snacks",
            image = R.drawable.bakery,
            color = ColorCategory3
        ),
        Category(
            id = 5,
            name = "Dairy & Eggs",
            image = R.drawable.egg,
            color = ColorCategory4
        ),
        Category(
            id = 6,
            name = "Bevarages",
            image = R.drawable.bevarages,
            color = ColorCategory5
        ),
        Category(
            id = 1,
            name = "Frash Fruits & Vegetable",
            image = R.drawable.fruit,
            color = PrimaryColor
        ),
        Category(
            id = 2,
            name = "Cooking Oil & Ghee",
            image = R.drawable.cook,
            color = ColorCategory1
        ),
        Category(
            id = 3,
            name = "Meat & Fish",
            image = R.drawable.meat,
            color = ColorCategory2
        ),
        Category(
            id = 4,
            name = "Bakery & Snacks",
            image = R.drawable.bakery,
            color = ColorCategory3
        ),
    )
}


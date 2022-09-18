package com.randev.online_groceries.screen.dashboard.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.data.Category
import com.randev.online_groceries.ui.core.VerticalSpace

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun GroceriesSection(
    modifier: Modifier = Modifier,
    categoryList: List<Category>,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        SectionTitle(
            title = "Groceries",
            onClickSeeAll = onClick
        )
        VerticalSpace(height = 20.dp)
        LazyRow {
            items(categoryList.size){ index ->
                CategoryItem(category = categoryList[index])
            }
        }
    }
}
package com.randev.online_groceries.screen.dashboard.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.Category
import com.randev.online_groceries.data.DummyDataCategory
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category
) {
    Card(
        modifier = modifier
            .width(249.dp)
            .height(105.dp)
            .padding(end = 15.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(18.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(category.color)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier
                    .size(72.dp),
                painter = painterResource(id = category.image),
                contentDescription = null
            )
            HorizontalSpace(width = 15.dp)
            Text(
                text = category.name,
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategoryItem() {
    OnlineGroceriesTheme {
        CategoryItem(
            category = DummyDataCategory.categoryList()[0]
        )
    }
}
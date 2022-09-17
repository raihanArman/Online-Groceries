package com.randev.online_groceries.feature.screen.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.DummyDataBanner
import com.randev.online_groceries.data.DummyDataCategory
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.feature.screen.dashboard.home.components.CarouselHome
import com.randev.online_groceries.feature.screen.dashboard.home.components.ExclusiveOfferSection
import com.randev.online_groceries.feature.screen.dashboard.home.components.GroceriesSection
import com.randev.online_groceries.feature.screen.dashboard.home.components.HeaderHome
import com.randev.online_groceries.feature.screen.dashboard.home.components.OtherSection
import com.randev.online_groceries.feature.screen.dashboard.home.components.ProductItem
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.components.textfield.TextFieldSearch
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.ThirdColor

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
    ){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                HeaderHome()
            }
            item {
                TextFieldSearch(
                    query = "",
                    onQueryChanged = {},
                    hintText = "Search store"
                )
            }
            item {
                CarouselHome(bannerList = DummyDataBanner.bannerList())
            }
            item {
                ExclusiveOfferSection(
                    productList = DummyDataProduct.productList(),
                    onClick = {}
                )
            }
            item {
                GroceriesSection(
                    categoryList = DummyDataCategory.categoryList(),
                    onClick = {}
                )
            }
            item { 
                OtherSection(productList = DummyDataProduct.productList())
            }
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    OnlineGroceriesTheme {
        HomeScreen()
    }
}

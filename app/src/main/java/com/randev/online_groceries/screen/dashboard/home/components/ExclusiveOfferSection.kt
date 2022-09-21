package com.randev.online_groceries.screen.dashboard.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun ExclusiveOfferSection(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    productList: List<Product>,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        SectionTitle(
            title = "Exclusive Offer",
            onClickSeeAll = onClick
        )
        VerticalSpace(height = 20.dp)
        LazyRow {
            items(productList.size){ index ->
                ProductItem(
                    product = productList[index],
                    onClick = {
                        navHostController.navigate(Screen.Details.passProductId(productList[index].id))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewExclusiveOfferSection() {
    OnlineGroceriesTheme {
        val navHostController = NavHostController(LocalContext.current)
        ExclusiveOfferSection(
            productList = DummyDataProduct.productList(),
            onClick = {},
            navHostController = navHostController
        )
    }
}
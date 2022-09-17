package com.randev.online_groceries.feature.screen.dashboard.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun OtherSection(
    modifier: Modifier = Modifier,
    productList: List<Product>
) {
    LazyRow(
        modifier = modifier
            .padding(bottom = 24.dp)
    ) {
        items(productList.size){ index ->
            ProductItem(product = productList[index])
        }
    }
}
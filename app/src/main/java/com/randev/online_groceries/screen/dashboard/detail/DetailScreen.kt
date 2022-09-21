package com.randev.online_groceries.screen.dashboard.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.screen.dashboard.detail.components.CounterSection
import com.randev.online_groceries.screen.dashboard.detail.components.DescriptionSection
import com.randev.online_groceries.screen.dashboard.detail.components.ProductImage
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun DetailScreen() {
    val data = DummyDataProduct.productList()[0]
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ){
        Column {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                ProductImage(product = data)
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(
                            start = 25.dp,
                            top = 25.dp,
                            end = 25.dp
                        )
                ) {
                    CounterSection(product = data)
                    DescriptionSection(product = data)
                }
            }
            Box(modifier = Modifier.padding(25.dp)){
                PrimaryButton(text = "Add to Basket", onClick = { })
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    OnlineGroceriesTheme {
        DetailScreen()
    }
}
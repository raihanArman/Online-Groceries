package com.randev.online_groceries.screen.dashboard.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.screen.dashboard.cart.components.CartItem
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.appbar.MainTopBar
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 20/09/22
 */

@Composable
fun CartScreen() {
    val data = DummyDataProduct.productList()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column {
            MainTopBar(title = "My Cart")
            LazyColumn(
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, top = 16.dp)
                    .weight(1f)
            ){
                items(data.size){ index ->
                    CartItem(product = data[index])
                }
            }
            PrimaryButton(
                modifier = Modifier
                    .padding(25.dp),
                text = "Go to Checkout",
                onClick = {},
                badge = {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = Color.Black.copy(alpha = 0.2f)
                    ){
                        Text(
                            text = "\$12.96",
                            color = Color.White,
                            fontFamily = MaterialTheme.typography.h3.fontFamily,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewCartScreen() {
    OnlineGroceriesTheme {
        CartScreen()
    }
}
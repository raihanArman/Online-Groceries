package com.randev.online_groceries.screen.dashboard.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.screen.dashboard.cart.components.CartItem
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.appbar.MainTopBar
import com.randev.online_groceries.ui.components.badge.BadgeCustom
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 20/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CartScreen(
    sheetState: ModalBottomSheetState
) {
    val data = DummyDataProduct.productList()
    val coroutineScope = rememberCoroutineScope()

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
                onClick = {
                    coroutineScope.launch {
                        sheetState.show()
                    }
                },
                badge = {
                    BadgeCustom(text =  "\$12.96", textSize = 12.sp)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewCartScreen() {
    OnlineGroceriesTheme {
//        CartScreen()
    }
}
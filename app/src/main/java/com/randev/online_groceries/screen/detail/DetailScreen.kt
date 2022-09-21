package com.randev.online_groceries.screen.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.screen.detail.components.CounterSection
import com.randev.online_groceries.screen.detail.components.DescriptionSection
import com.randev.online_groceries.screen.detail.components.ProductImage
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.utils.DETAILS_ARGUMENT_KEY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun DetailScreen(
    navHostController: NavHostController,
    productId: Int
) {
    val product: MutableState<Product?> = remember {
        mutableStateOf(null)
    }

    LaunchedEffect(key1 = true){
        product.value = DummyDataProduct.productList().find {
            it.id == productId
        }
        Log.d("DetailScreen", "DetailScreen: productId -> $productId")
        Log.d("DetailScreen", "DetailScreen: ${product.value}")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ){
        product.value?.let { data ->
            Column {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    ProductImage(product = data, onBack = {
                        navHostController.popBackStack()
                    })
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
}

@Preview
@Composable
fun PreviewDetailScreen() {
    OnlineGroceriesTheme {
//        DetailScreen()
    }
}
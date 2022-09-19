package com.randev.online_groceries.screen.dashboard.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.screen.dashboard.favorite.components.FavoriteItem
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.appbar.MainTopBar
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun FavoriteScreen() {
    val data = DummyDataProduct.productList()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Column {
            MainTopBar(title = "Favorite")
            LazyColumn(
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, top = 16.dp)
                    .weight(1f)
            ) {
                items(data.size){ index ->
                    FavoriteItem(product = data[index])
                }
            }
            PrimaryButton(
                modifier = Modifier
                    .padding(25.dp),
                text = "Add all to Cart",
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewFavoriteScreen() {
    OnlineGroceriesTheme {
        FavoriteScreen()
    }
}
package com.randev.online_groceries.screen.dashboard.favorite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun FavoriteItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(115.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(54.dp)
                        .padding(end = 42.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = product.name,
                        fontFamily = MaterialTheme.typography.h4.fontFamily,
                        fontSize = 16.sp,
                        color = SecondaryColor
                    )
                    VerticalSpace(height = 6.dp)
                    Text(
                        text = product.unit,
                        fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                        fontSize = 14.sp,
                        color = GreyColor
                    )
                }
                Text(
                    text = product.price,
                    fontFamily = MaterialTheme.typography.h3.fontFamily,
                    fontSize = 16.sp,
                    color = SecondaryColor
                )
                HorizontalSpace(width = 16.dp)
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Divider(
                modifier = Modifier.height(1.dp),
                color = BorderColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewFavoriteItem() {
    OnlineGroceriesTheme {
        FavoriteItem(
            product = DummyDataProduct.productList()[0]
        )
    }
}
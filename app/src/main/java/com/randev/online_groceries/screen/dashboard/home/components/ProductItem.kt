package com.randev.online_groceries.screen.dashboard.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    Card(
        modifier = modifier
            .width(174.dp)
            .height(249.dp)
            .padding(end = 16.dp),
        border = BorderStroke(1.dp, color = BorderColor),
        backgroundColor = Color.White,
        elevation = 0.dp,
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Image(
                    modifier = Modifier
                        .height(85.dp),
                    painter = painterResource(id = product.image),
                    contentDescription =  null
                )
            }
            Text(
                text = product.name,
                fontSize = 16.sp,
                fontFamily = MaterialTheme.typography.h4.fontFamily,
                color = SecondaryColor
            )
            VerticalSpace(height = 5.dp)
            Text(
                text = product.unit,
                fontSize = 14.sp,
                fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                color = GreyColor
            )
            VerticalSpace(height = 20.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = product.price,
                    fontSize = 18.sp,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    color = SecondaryColor
                )
                Button(
                    modifier = Modifier
                        .size(45.dp),
                    shape = RoundedCornerShape(17.dp),
                    onClick = {},
                    contentPadding = PaddingValues()
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewProductItem() {
    OnlineGroceriesTheme {
        ProductItem(
            product = DummyDataProduct.productList()[0]
        )
    }
}
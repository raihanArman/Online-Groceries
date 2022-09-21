package com.randev.online_groceries.screen.dashboard.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun CounterSection(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = modifier
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = product.name,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontSize = 24.sp,
                    color = SecondaryColor
                )
                VerticalSpace(height = 10.dp)
                Text(
                    text = product.unit,
                    fontFamily = MaterialTheme.typography.h3.fontFamily,
                    fontSize = 16.sp,
                    color = TextGreyColor
                )
            }
            IconButton(
                modifier = Modifier
                    .size(24.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = null,
                    tint = GreyColor
                )
            }
        }
        VerticalSpace(height = 30.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(24.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_remove_24),
                    contentDescription = null,
                    tint = GreyColor.copy(alpha = 0.7f)
                )
            }
            HorizontalSpace(width = 18.dp)
            Card(
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, color = BorderColor),
                modifier = Modifier
                    .size(45.dp),
                elevation = 0.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "1",
                        fontFamily = MaterialTheme.typography.h3.fontFamily,
                        fontSize = 16.sp,
                        color = SecondaryColor
                    )
                }
            }
            HorizontalSpace(width = 18.dp)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = PrimaryColor
                )
            }
            Text(
                text = product.price,
                fontFamily = MaterialTheme.typography.h4.fontFamily,
                fontSize = 24.sp,
                color = SecondaryColor,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.End
            )
        }
        VerticalSpace(height = 30.dp)
        Divider(color = BorderColor)
    }
}

@Preview
@Composable
fun PreviewCounterSection() {
    OnlineGroceriesTheme() {
        CounterSection(product = DummyDataProduct.productList()[0])
    }
}
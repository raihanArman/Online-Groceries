package com.randev.online_groceries.screen.dashboard.cart.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(157.dp)
            .background(Color.White)
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
                        .width(68.dp)
                )
                HorizontalSpace(width = 33.dp)
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top
                    ){
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
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(20.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = GreyColor.copy(alpha = 0.7f)
                            )
                        }
                    }
                    VerticalSpace(height = 14.dp)
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(17.dp),
                            border = BorderStroke(1.dp, color = BorderColor),
                            modifier = Modifier
                                .size(45.dp),
                            contentPadding = PaddingValues(10.dp)
                        ){
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
                        }
                        HorizontalSpace(width = 18.dp)
                        Text(
                            text = "1",
                            fontFamily = MaterialTheme.typography.h3.fontFamily,
                            fontSize = 16.sp,
                            color = SecondaryColor
                        )
                        HorizontalSpace(width = 18.dp)
                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(17.dp),
                            border = BorderStroke(1.dp, color = BorderColor),
                            modifier = Modifier
                                .size(45.dp),
                            contentPadding = PaddingValues(10.dp)
                        ){
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
                        }
                        Text(
                            text = product.price,
                            fontFamily = MaterialTheme.typography.h3.fontFamily,
                            fontSize = 16.sp,
                            color = SecondaryColor,
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.End
                        )
                    }
                }

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
        CartItem(
            product = DummyDataProduct.productList()[0]
        )
    }
}
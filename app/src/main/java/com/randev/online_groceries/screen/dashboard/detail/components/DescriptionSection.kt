package com.randev.online_groceries.screen.dashboard.detail.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.ui.components.badge.BadgeCustom
import com.randev.online_groceries.ui.components.rating.RatingWidget
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.TextGreyColor
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

private const val MINIMIZED_MAX_LINES = 2

@Composable
fun DescriptionSection(
    modifier: Modifier = Modifier,
    product: Product
) {
    val coroutineScope = rememberCoroutineScope()
    var isExpanded by remember { mutableStateOf(false) }
    val rotate = remember { Animatable(0f) }

    Column(
        modifier = modifier
    ) {
        VerticalSpace(height = 19.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "Product Detail",
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 16.sp,
                color = SecondaryColor
            )
            IconButton(
                modifier = Modifier
                    .size(24.dp),
                onClick = {
                    coroutineScope.launch {
                        rotate.animateTo(
                            targetValue = if (!isExpanded) 0f else 180f,
                        )
                    }

                    isExpanded = !isExpanded
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(degrees = rotate.value),
                )
            }
        }
        VerticalSpace(height = 10.dp)
        Text(
            text = product.description,
            fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
            fontSize = 13.sp,
            color = TextGreyColor,
            maxLines = if (isExpanded) Int.MAX_VALUE else MINIMIZED_MAX_LINES,
            modifier = Modifier
                .animateContentSize()
        )
        VerticalSpace(height = 19.dp)
        Divider(color = BorderColor)
        VerticalSpace(height = 19.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Nutrition",
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 16.sp,
                color = SecondaryColor,
                modifier = Modifier
                    .weight(1f)
            )
            BadgeCustom(text = "100gr", textSize = 9.sp)
            HorizontalSpace(width = 20.dp)
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
        }
        VerticalSpace(height = 19.dp)
        Divider(color = BorderColor)
        VerticalSpace(height = 19.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Review",
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 16.sp,
                color = SecondaryColor,
                modifier = Modifier
                    .weight(1f)
            )
            RatingWidget(rating = product.review)
            HorizontalSpace(width = 20.dp)
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDescriptionSection() {
    OnlineGroceriesTheme {
        DescriptionSection(product = DummyDataProduct.productList()[0])
    }
}
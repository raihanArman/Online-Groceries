package com.randev.online_groceries.feature.screen.dashboard.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.ThirdColor

/**
 * @author Raihan Arman
 * @date 17/09/22
 */


@Composable
fun HeaderHome(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_logo_color),
            contentDescription = null
        )
        VerticalSpace(height = 7.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                tint = ThirdColor
            )
            HorizontalSpace(width = 7.dp)
            Text(
                text = "Makassar, Indonesia",
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 18.sp,
                color = ThirdColor
            )
        }
    }
}

@Preview
@Composable
fun HearderHome() {
    OnlineGroceriesTheme {
        HeaderHome()
    }
}
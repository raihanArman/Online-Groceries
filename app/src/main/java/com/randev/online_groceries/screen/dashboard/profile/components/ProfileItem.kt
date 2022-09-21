package com.randev.online_groceries.screen.dashboard.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun ProfileItem(
    onClick:() -> Unit = {},
    title: String = "",
    icon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp),
                contentAlignment = Alignment.Center
            ){
                Image(painter = painterResource(id = icon), contentDescription = null)
            }
            HorizontalSpace(width = 20.dp)
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 18.sp,
                color = SecondaryColor
            )
            IconButton(
                onClick = onClick,
                modifier = Modifier.size(16.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24), contentDescription = null)
            }
        }
        Divider(color = BorderColor)
    }
}

@Preview
@Composable
fun PreviewProfileItem() {
    OnlineGroceriesTheme {
        ProfileItem(
            title = "Orders",
            icon = R.drawable.ic_order
        )
    }
}
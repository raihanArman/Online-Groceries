package com.randev.online_groceries.screen.dashboard.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun HeaderProfile(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
    ){
        Column {
            Row(
                modifier = Modifier
                    .padding(25.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                HorizontalSpace(width = 20.dp)
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Raihan Arman",
                            fontFamily = MaterialTheme.typography.h4.fontFamily,
                            fontSize = 20.sp,
                            color = SecondaryColor
                        )
                        HorizontalSpace(width = 15.dp)
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                tint = PrimaryColor
                            )
                        }
                    }
                    VerticalSpace(height = 5.dp)
                    Text(
                        text = "raihan@gmail.com",
                        fontFamily = MaterialTheme.typography.caption.fontFamily,
                        fontSize = 16.sp,
                        color = GreyColor
                    )
                }
            }
            Divider(color = BorderColor)
        }
    }
}

@Preview
@Composable
fun PreviewHeaderProfile() {
    OnlineGroceriesTheme {
        HeaderProfile()
    }
}
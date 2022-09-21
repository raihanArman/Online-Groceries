package com.randev.online_groceries.screen.dashboard.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.R
import com.randev.online_groceries.screen.dashboard.profile.components.HeaderProfile
import com.randev.online_groceries.screen.dashboard.profile.components.ProfileItem
import com.randev.online_groceries.ui.components.button.SocialMediaButton
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            HeaderProfile()
            Column(
                modifier = Modifier
                    .padding(
                        start = 25.dp,
                        end = 25.dp
                    )
            ) {
                ProfileItem(
                    title = "Orders",
                    icon = R.drawable.ic_order
                )
                ProfileItem(
                    title = "My Details",
                    icon = R.drawable.ic_details
                )
                ProfileItem(
                    title = "Delivery Address",
                    icon = R.drawable.ic_address
                )
                ProfileItem(
                    title = "Payment Methods",
                    icon = R.drawable.ic_payment_method
                )
                ProfileItem(
                    title = "Promo Card",
                    icon = R.drawable.ic_promo
                )
                ProfileItem(
                    title = "Notification",
                    icon = R.drawable.ic_bell
                )
                ProfileItem(
                    title = "Help",
                    icon = R.drawable.ic_help
                )
                ProfileItem(
                    title = "About",
                    icon = R.drawable.ic_about
                )
                VerticalSpace(height = 20.dp)
                SocialMediaButton(
                    onClick = {},
                    text = "Log Out",
                    imageResource = R.drawable.ic_logout,
                    backgroundColor = BorderColor,
                    textColor = PrimaryColor
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    OnlineGroceriesTheme {
        ProfileScreen()
    }
}
package com.randev.online_groceries.screen.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 22/09/22
 */

@Composable
fun OrderAcceptedScreen(
    navHostController: NavHostController
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.bg_order_accepted),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.ic_done),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 30.dp)
                        )
                    }
                    VerticalSpace(height = 66.dp)
                    Text(
                        text = "Your order has been accepted",
                        fontFamily = MaterialTheme.typography.h3.fontFamily,
                        fontSize = 28.sp,
                        color = SecondaryColor,
                        modifier = Modifier
                            .width(265.dp),
                        textAlign = TextAlign.Center
                    )
                    VerticalSpace(height = 20.dp)
                    Text(
                        text = "Your items has been placcd and is on it’s way to being processed",
                        fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                        fontSize = 16.sp,
                        color = TextGreyColor,
                        modifier = Modifier
                            .width(278.dp),
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(25.dp)
            ) {
                PrimaryButton(text = "Track Order", onClick = { showDialog = !showDialog })
                TextButton(
                    onClick = {
                        navHostController.navigateAndReplaceStartRoute(Screen.Dashboard.route)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Back to Home",
                        fontFamily = MaterialTheme.typography.h3.fontFamily,
                        fontSize = 18.sp,
                        color = SecondaryColor
                    )
                }
            }
        }
    }

    if(showDialog){
        OrderDialog(
            onDismiss = {
                showDialog = !showDialog
            },
            onBackToHome = {
                navHostController.navigateAndReplaceStartRoute(Screen.Dashboard.route)
            },
            onPleaseTryAgain = {
                showDialog = !showDialog
            }
        )
    }

}

@Preview
@Composable
fun PreviewOrderAcceptedScreen() {
    OnlineGroceriesTheme {
        val navHostController = rememberNavController()
        OrderAcceptedScreen(navHostController = navHostController)
    }
}
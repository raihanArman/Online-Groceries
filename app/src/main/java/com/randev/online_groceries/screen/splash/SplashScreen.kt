package com.randev.online_groceries.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.navigation.popUpToTop
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import kotlinx.coroutines.delay

/**
 * @author Raihan Arman
 * @date 13/09/22
 */

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = true){
        delay(3000)
        navHostController.navigateAndReplaceStartRoute(Screen.Onboard.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
           Image(
               modifier = Modifier
                   .width(54.dp),
               painter = painterResource(id = R.drawable.ic_logo),
               contentDescription = null
           )
           Column(
               modifier = Modifier
                   .padding(start = 16.dp)
           ) {
               Text(
                   text = stringResource(R.string.logo_title),
                   fontSize = 54.sp,
                   color = Color.White,
                   fontFamily = MaterialTheme.typography.subtitle1.fontFamily
               )
               Text(
                   text = stringResource(R.string.logo_subtitle),
                   fontSize = 16.sp,
                   color = Color.White,
                   fontFamily = MaterialTheme.typography.caption.fontFamily
               )
           }
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    OnlineGroceriesTheme {
        SplashScreen(navHostController = NavHostController(LocalContext.current))
    }
}
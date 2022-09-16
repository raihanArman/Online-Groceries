package com.randev.online_groceries.feature.screen.auth.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.ui.components.button.SocialMediaButton
import com.randev.online_groceries.ui.components.text.TitleText
import com.randev.online_groceries.ui.components.textfield.TextFieldPhoneNumber
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.FacebookColor
import com.randev.online_groceries.ui.theme.GoogleColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun SignInScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.bg_sign_in),
                contentDescription = null,
            )
        }
        FieldSignIn(
            navHostController = navHostController
        )
    }
}

@Composable
fun FieldSignIn(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Column(
        modifier = modifier
            .padding(25.dp),
    ) {
        TitleText(
            modifier = Modifier
                .width(222.dp),
            text = "Get your groceries with nectar",
        )
        VerticalSpace(height = 30.dp)
        TextFieldPhoneNumber(
            modifier = Modifier
                .fillMaxWidth(),
            text = "",
            onTextChanged = {},
            onFlagClick = {},
            readOnly = true
        )
        VerticalSpace(height = 40.dp)
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Or connect with social media",
            fontFamily = MaterialTheme.typography.h3.fontFamily,
            fontSize = 14.sp,
            color = TextGreyColor,
            textAlign = TextAlign.Center
        )
        VerticalSpace(height = 37.dp)
        SocialMediaButton(
            onClick = {
                navHostController.navigate(Screen.FieldNumber.route)
            },
            text = "Continue with Google",
            imageResource = R.drawable.ic_google,
            backgroundColor = GoogleColor
        )
        VerticalSpace(height = 20.dp)
        SocialMediaButton(
            onClick = {},
            text = "Continue with Facebook",
            imageResource = R.drawable.ic_facebook,
            backgroundColor = FacebookColor
        )

    }
}

@Preview
@Composable
fun PreviewSignInScreen() {
    OnlineGroceriesTheme {
        SignInScreen(navHostController = NavHostController(LocalContext.current))
    }
}
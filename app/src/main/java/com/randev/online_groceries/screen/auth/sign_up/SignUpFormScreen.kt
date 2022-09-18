package com.randev.online_groceries.screen.auth.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.navigation.popUpToTop
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.text.DescriptionText
import com.randev.online_groceries.ui.components.text.TitleText
import com.randev.online_groceries.ui.components.textfield.TextFieldCustom
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@Composable
fun SignUpFormScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_number_field),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(25.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_color),
                contentDescription = null
            )
            VerticalSpace(height = 100.dp)
            TitleText(
                text = "Sign Up",
                modifier = Modifier
                    .fillMaxWidth()
            )
            VerticalSpace(height = 8.dp)
            DescriptionText(
                text = "Enter your credentials to continue",
                modifier = Modifier
                    .fillMaxWidth()
            )
            VerticalSpace(height = 40.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                title = "Username"
            )
            VerticalSpace(height = 30.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                title = "Email"
            )
            VerticalSpace(height = 30.dp)
            TextFieldCustom(
                title = "Password",
                text = "",
                onTextChanged = {},
                isPasswordTextFieldProvider = {true}
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "Forgot Password ?",
                        color = SecondaryColor,
                        fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                        fontSize = 14.sp,
                    )
                }
            }
            VerticalSpace(height = 15.dp)
            PrimaryButton(
                text = "Sign Up",
                onClick = {
                    navHostController.navigateAndReplaceStartRoute(Screen.Dashboard.route)
                }
            )
            VerticalSpace(height = 15.dp)
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(TextGreyColor)){
                                append("By continuing you agree to our ")
                            }
                            withStyle(style = SpanStyle(MaterialTheme.colors.primary)){
                                append("Terms of Service and Privacy Policy.")
                            }
                        },
                        fontSize = 14.sp,
                        fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignUpFormScreen() {
    OnlineGroceriesTheme {
        SignUpFormScreen(navHostController = NavHostController(LocalContext.current))
    }
}
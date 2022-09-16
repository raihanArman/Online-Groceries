package com.randev.online_groceries.feature.screen.auth.field

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.ui.components.button.BackButton
import com.randev.online_groceries.ui.components.textfield.TextFieldPhoneNumber
import com.randev.online_groceries.ui.components.text.TitleText
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun NumberFieldScreen(
    navHostController: NavHostController
) {

    val phoneNumberValue = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_number_field),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Scaffold(
            backgroundColor = Color.Transparent,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp, top = 50.dp)
                ) {
                    BackButton(
                        onClick = {
                            navHostController.popBackStack()
                        }
                    )
                    VerticalSpace(height = 65.dp)
                    TitleText(text = "Enter your mobile number")
                    VerticalSpace(height = 27.dp)
                    TextFieldPhoneNumber(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = Color.Transparent,
                        title = "Mobile Number",
                        text = phoneNumberValue.value,
                        onTextChanged = {
                            phoneNumberValue.value = it
                        },
                        onFlagClick = {},
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {
                        navHostController.navigate(Screen.FieldOtp.route)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        )
    }
}


@Preview
@Composable
fun PreviewNumberFieldScreen() {
    OnlineGroceriesTheme {
        NumberFieldScreen(navHostController = NavHostController(LocalContext.current))
    }
}
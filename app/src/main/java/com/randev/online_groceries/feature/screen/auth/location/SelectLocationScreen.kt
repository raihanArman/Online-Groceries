package com.randev.online_groceries.feature.screen.auth.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.randev.online_groceries.R
import com.randev.online_groceries.data.Country
import com.randev.online_groceries.data.DummyDataCountry
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.navigation.popUpToTop
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.button.BackButton
import com.randev.online_groceries.ui.components.text.DescriptionText
import com.randev.online_groceries.ui.components.text.TitleText
import com.randev.online_groceries.ui.components.textfield.TextFieldCustom
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectLocationScreen(
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
                .padding(25.dp),
        ) {
            BackButton(
                onClick = {
                    navHostController.popBackStack()
                }
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_map_point),
                    contentDescription = null
                )
            }
            TitleText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Select Your Location",
                textAlign = TextAlign.Center
            )
            VerticalSpace(height = 15.dp)
            DescriptionText(
                modifier = Modifier
                    .width(324.dp),
                text = "Switch on your location to stay in tune with what’s happening in your area",
                textSize = 16.sp,
                textAlign = TextAlign.Center
            )
            VerticalSpace(height = 89.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                textHint = "Types of your zone",
                title = "Your Zone",
                trailingIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        IconDropdown()
                    }
                },
            )
            VerticalSpace(height = 30.dp)
            TextFieldCustom(
                text = "",
                onTextChanged = {},
                textHint = "Types of your area",
                title = "Your Area",
                trailingIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        IconDropdown()
                    }
                }
            )
            VerticalSpace(height = 40.dp)
            PrimaryButton(
                text = "Submit",
                onClick = {
                    navHostController.navigateAndReplaceStartRoute(Screen.SignInForm.route)
                }
            )
        }
    }
}

@Composable
fun IconDropdown() {
    Icon(
        painter = painterResource(id = R.drawable.ic_baseline_expand_more_24),
        contentDescription = null
    )
}

@Preview
@Composable
fun PreviewSelectLocationScreen() {
    OnlineGroceriesTheme {
        SelectLocationScreen(navHostController = NavHostController(LocalContext.current))
    }
}
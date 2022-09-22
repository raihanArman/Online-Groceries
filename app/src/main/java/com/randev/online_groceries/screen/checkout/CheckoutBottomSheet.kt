package com.randev.online_groceries.screen.checkout

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.TextGreyColor
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 22/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckoutBottomSheet(
    sheetState: ModalBottomSheetState,
    backgroundContent: @Composable () -> Unit,
    navHostController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    BackHandler(enabled = sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }
    
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetBackgroundColor = Color.White,
        sheetContent = {
            Box(
                modifier = Modifier
                    .background(Color.White)
            ){
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                    ){
                        Text(
                            text = "Checkout",
                            fontFamily = MaterialTheme.typography.h3.fontFamily,
                            fontSize = 24.sp,
                            color = SecondaryColor
                        )
                        IconButton(
                            modifier = Modifier
                                .size(20.dp),
                            onClick = {
                                coroutineScope.launch {
                                    sheetState
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    }
                    Divider(color = BorderColor)
                    Column(
                        modifier = Modifier
                            .padding(start = 25.dp, end = 25.dp, bottom = 25.dp)
                    ) {
                        Items(title = "Delivery") {
                            Text(
                                text = "Select Method",
                                fontFamily = MaterialTheme.typography.h3.fontFamily,
                                fontSize = 16.sp,
                                color = SecondaryColor
                            )
                        }
                        Items(title = "Payment") {
                            Box(
                                modifier = Modifier.size(20.dp),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.card),
                                    contentDescription = null
                                )
                            }
                        }
                        Items(title = "Promo Code") {
                            Text(
                                text = "Pick Discount",
                                fontFamily = MaterialTheme.typography.h3.fontFamily,
                                fontSize = 16.sp,
                                color = SecondaryColor
                            )
                        }
                        Items(title = "Total Cast") {
                            Text(
                                text = "\$13.97",
                                fontFamily = MaterialTheme.typography.h3.fontFamily,
                                fontSize = 16.sp,
                                color = SecondaryColor
                            )
                        }
                        VerticalSpace(height = 20.dp)
                        Text(
                            modifier = Modifier
                                .width(240.dp),
                            lineHeight = 25.sp,
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(
                                    TextGreyColor,
                                    fontFamily = MaterialTheme.typography.h3.fontFamily,
                                    fontSize = 14.sp
                                )){
                                    append("By placing on order you agree to our  ")
                                }
                                withStyle(style = SpanStyle(SecondaryColor)){
                                    append("Term")
                                }
                                withStyle(style = SpanStyle(TextGreyColor)){
                                    append(" And ")
                                }
                                withStyle(style = SpanStyle(SecondaryColor)){
                                    append("Conditions")
                                }
                            },
                            fontSize = 14.sp,
                            fontFamily = MaterialTheme.typography.subtitle1.fontFamily
                        )
                        VerticalSpace(height = 26.dp)
                        PrimaryButton(text = "Place Order", onClick = {
                            navHostController.navigateAndReplaceStartRoute(Screen.OrderAccepted.route)
                        })
                    }
                }
            }
        }
    ){
        backgroundContent()
    }
    
}

@Composable
fun Items(
    title: String,
    actionTitle: @Composable () -> Unit,
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
        ){
            Text(
                text = title,
                color = TextGreyColor,
                fontFamily = MaterialTheme.typography.h3.fontFamily,
                fontSize = 18.sp,
                modifier = Modifier
                    .weight(1f)
            )
            actionTitle()
            HorizontalSpace(width = 15.dp)
            IconButton(
                modifier = Modifier
                    .size(15.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
        }
        Divider(color = BorderColor)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun PreviewBottomSheet() {
    OnlineGroceriesTheme() {
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
        val coroutineScope = rememberCoroutineScope()
        val navHostController = rememberNavController()
        CheckoutBottomSheet(
            sheetState = sheetState,
            navHostController = navHostController,
            backgroundContent = {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        coroutineScope.launch { sheetState.show() }
                    }) {
                    Text(text = "Test")
                }
            }
        )
    }
}
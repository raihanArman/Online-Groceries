package com.randev.online_groceries.screen.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.navigation.navigateAndReplaceStartRoute
import com.randev.online_groceries.navigation.setupDashboardBottomNavScreens
import com.randev.online_groceries.screen.checkout.CheckoutBottomSheet
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardScreen(
    navHostController: NavHostController
) {
    var currentSelectedItem: DashboardBottomBarItemType by remember {
        mutableStateOf(
            DashboardBottomBarItemType.HOME
        )
    }
    val iconSize = remember { 24.dp }
    val dashboardNav = rememberNavController()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Scaffold(
        bottomBar = {
            DashboardBottomBar(
                navController = dashboardNav,
                isDisplayed = true,
                bottomBarItems = listOf(
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.HOME,
                        label = "Home",
                        route = Screen.Home.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_explore),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.EXPLORE,
                        label = "Explore",
                        route = Screen.Explore.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.CART,
                        label = "Cart",
                        notifCount = 5,
                        route = Screen.Cart.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.FAVORITE,
                        label = "Favorite",
                        route = Screen.Favorite.route
                    ),
                    DashboardBottomBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_account),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(iconSize),
                            )
                        },
                        type = DashboardBottomBarItemType.ACCOUNT,
                        label = "Account",
                        route = Screen.Account.route
                    ),
                )
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding())
            ) {
                NavHost(
                    navController = dashboardNav,
                    startDestination = "dashboardBottomNav"
                ){
                    setupDashboardBottomNavScreens(navHostController, sheetState)
                }
            }
        }
    )

    CheckoutBottomSheet(
        sheetState = sheetState,
        backgroundContent = {},
        navHostController = navHostController
    )

}

@Preview
@Composable
fun PreviewDashboardScreen() {
    val navController = rememberNavController()
    OnlineGroceriesTheme() {
        DashboardScreen(navHostController = navController)
    }
}
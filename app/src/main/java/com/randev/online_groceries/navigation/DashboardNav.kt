package com.randev.online_groceries.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.randev.online_groceries.feature.screen.dashboard.HomeScreen
import com.randev.online_groceries.screen.dashboard.cart.CartScreen
import com.randev.online_groceries.screen.dashboard.explore.ExploreScreen
import com.randev.online_groceries.screen.dashboard.favorite.FavoriteScreen
import com.randev.online_groceries.screen.dashboard.profile.ProfileScreen

/**
 * @author Raihan Arman
 * @date 18/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.setupDashboardBottomNavScreens(
    navHostController: NavHostController,
    sheetState: ModalBottomSheetState
){
    navigation(
        startDestination = Screen.Home.route,
        route = "dashboardBottomNav"
    ){
        composable(Screen.Home.route){
            HomeScreen(navHostController)
        }
        composable(Screen.Explore.route){
            ExploreScreen()
        }
        composable(Screen.Favorite.route){
            FavoriteScreen()
        }
        composable(Screen.Cart.route) {
            CartScreen(sheetState)
        }
        composable(Screen.Account.route) {
            ProfileScreen()
        }
    }
}
package com.randev.online_groceries.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.randev.online_groceries.feature.screen.dashboard.HomeScreen
import com.randev.online_groceries.screen.dashboard.explore.ExploreScreen
import com.randev.online_groceries.screen.dashboard.favorite.FavoriteScreen

/**
 * @author Raihan Arman
 * @date 18/09/22
 */

fun NavGraphBuilder.setupDashboardBottomNavScreens(){
    navigation(
        startDestination = Screen.Home.route,
        route = "dashboardBottomNav"
    ){
        composable(Screen.Home.route){
            HomeScreen()
        }
        composable(Screen.Explore.route){
            ExploreScreen()
        }
        composable(Screen.Favorite.route){
            FavoriteScreen()
        }

    }
}
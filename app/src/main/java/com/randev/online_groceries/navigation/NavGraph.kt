package com.randev.online_groceries.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.randev.online_groceries.feature.screen.auth.field.NumberFieldScreen
import com.randev.online_groceries.feature.screen.auth.field.OtpFieldScreen
import com.randev.online_groceries.feature.screen.auth.location.SelectLocationScreen
import com.randev.online_groceries.feature.screen.auth.sign_in.SignInScreen
import com.randev.online_groceries.feature.screen.auth.sign_in_form.SignInFormScreen
import com.randev.online_groceries.feature.screen.auth.sign_up.SignUpFormScreen
import com.randev.online_groceries.feature.screen.dashboard.DashboardScreen
import com.randev.online_groceries.feature.screen.onboard.OnBoardScreen
import com.randev.online_groceries.feature.screen.splash.SplashScreen

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.Splash.route){
            SplashScreen(navController)
        }
        composable(Screen.Onboard.route){
            OnBoardScreen(navController)
        }
        composable(Screen.SignIn.route){
            SignInScreen(navController)
        }
        composable(Screen.FieldNumber.route){
            NumberFieldScreen(navController)
        }
        composable(Screen.FieldOtp.route){
            OtpFieldScreen(navController)
        }
        composable(Screen.SelectLocation.route){
            SelectLocationScreen(navController)
        }
        composable(Screen.SignInForm.route){
            SignInFormScreen(navController)
        }
        composable(Screen.SignUpForm.route){
            SignUpFormScreen(navController)
        }
        composable(Screen.Dashboard.route){
            DashboardScreen(navController)
        }
    }
}

fun NavOptionsBuilder.popUpToTop(navController: NavController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive =  true
    }
}

fun NavHostController.navigateAndReplaceStartRoute(newHomeRoute: String) {
    popBackStack(graph.startDestinationId, true)
    graph.setStartDestination(newHomeRoute)
    navigate(newHomeRoute)
}
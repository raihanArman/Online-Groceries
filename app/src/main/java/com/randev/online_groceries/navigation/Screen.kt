package com.randev.online_groceries.navigation

/**
 * @author Raihan Arman
 * @date 16/09/22
 */
sealed class Screen(
    val route: String
) {
    object Splash: Screen("splash")
    object Onboard: Screen("onboard")
    object SignIn: Screen("sign_in")
    object SignInForm: Screen("sign_in_form")
    object SignUpForm: Screen("sign_up_form")
    object FieldNumber: Screen("field_number")
    object FieldOtp: Screen("field_otp")
    object SelectLocation: Screen("select_location")
    object Dashboard: Screen("dashboard")

    //Dashboard
    object Home: Screen("home")
    object Explore: Screen("screen")
    object Cart: Screen("cart")
    object Favorite: Screen("favorite")
    object Account: Screen("account")
}
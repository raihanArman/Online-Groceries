package com.randev.online_groceries.navigation

import com.randev.online_groceries.utils.DETAILS_ARGUMENT_KEY

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
    object Details: Screen("details/{$DETAILS_ARGUMENT_KEY}"){
        fun passProductId(productId: Int): String {
            return "details/$productId"
        }
    }
    object OrderAccepted: Screen("order_accepted")

    //Dashboard
    object Home: Screen("home")
    object Explore: Screen("screen")
    object Cart: Screen("cart")
    object Favorite: Screen("favorite")
    object Account: Screen("account")
}
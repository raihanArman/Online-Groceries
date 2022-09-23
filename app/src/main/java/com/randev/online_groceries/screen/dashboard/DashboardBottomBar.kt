package com.randev.online_groceries.screen.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.R
import com.randev.online_groceries.navigation.Screen
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor

/**
 * @author Raihan Arman
 * @date 18/09/22
 */

enum class DashboardBottomBarItemType {
    HOME, EXPLORE, CART, FAVORITE, ACCOUNT
}

data class DashboardBottomBarItem(
    val icon: @Composable () -> Unit,
    val label: String,
    val notifCount: Int? = null,
    val type: DashboardBottomBarItemType,
    val route: String
)

val BottomNavigationHeight = 56.dp

@Composable
fun DashboardBottomBar(
    isDisplayed: Boolean,
    bottomBarItems: List<DashboardBottomBarItem>,
    navController: NavHostController
) {

    val surfaceColor = Color.White
    val contentColor = PrimaryColor
    
    AnimatedVisibility(
        visible = isDisplayed,
        enter = slideInVertically(animationSpec = tween(), initialOffsetY = {it}),
        exit = slideOutVertically(animationSpec = tween(), targetOffsetY = {it})
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
       BottomNavigation(
           backgroundColor = surfaceColor,
           contentColor = contentColor,
           modifier = Modifier
               .fillMaxWidth()
               .graphicsLayer {
                   clip = true
                   shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)
                   shadowElevation = 27f
               }
       ) {
           bottomBarItems.forEach { item ->
               if(!DashboardBottomBarItemType.values().contains(item.type)){
                   throw Exception("Unknown item type! Please add this type inside the DashboardBottomBarItemType enum class.")
               }

               BottomNavigationItem(
                   selected = currentRoute == item.route,
                   onClick = {
                       navController.navigate(item.route)
                   },
                   icon = {
                       IconIndicator(
                           count = item.notifCount,
                           forceCircleShape = false,
                           modifier = Modifier.padding(8.dp)
                       ) {
                           item.icon()
                       }
                   },
                   alwaysShowLabel = true,
                   selectedContentColor = contentColor,
                   unselectedContentColor = Color.Black,
                   label = {
                       Text(
                           text = item.label,
                           fontFamily = MaterialTheme.typography.h3.fontFamily,
                           fontSize = 12.sp
                       )
                   }
               )
           }
       }
    }
}

@Preview
@Composable
fun PreviewDashboardBottomBar() {
    OnlineGroceriesTheme() {
        val iconSize = remember { 24.dp }
        val navHostController = rememberNavController()

        DashboardBottomBar(
            navController = navHostController,
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
    }
}
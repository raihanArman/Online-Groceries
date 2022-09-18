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
import com.randev.online_groceries.R
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
    val isSelected: Boolean,
    val icon: @Composable () -> Unit,
    val label: String,
    val notifCount: Int? = null,
    val onClick: () -> Unit,
    val type: DashboardBottomBarItemType
)

val BottomNavigationHeight = 56.dp

@Composable
fun DashboardBottomBar(
    isDisplayed: Boolean,
    bottomBarItems: List<DashboardBottomBarItem>
) {

    val surfaceColor = Color.White
    val contentColor = PrimaryColor
    
    AnimatedVisibility(
        visible = isDisplayed,
        enter = slideInVertically(animationSpec = tween(), initialOffsetY = {it}),
        exit = slideOutVertically(animationSpec = tween(), targetOffsetY = {it})
    ) {
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
                   selected = item.isSelected,
                   onClick = item.onClick,
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
        var currentSelectedItem: DashboardBottomBarItemType by remember {
            mutableStateOf(
                DashboardBottomBarItemType.HOME
            )
        }
        val iconSize = remember { 24.dp }

        DashboardBottomBar(
            isDisplayed = true,
            bottomBarItems = listOf(
                DashboardBottomBarItem(
                    isSelected = currentSelectedItem == DashboardBottomBarItemType.HOME,
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
                    onClick = {
                        currentSelectedItem = DashboardBottomBarItemType.HOME
                    }
                ),
                DashboardBottomBarItem(
                    isSelected = currentSelectedItem == DashboardBottomBarItemType.EXPLORE,
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
                    onClick = {
                        currentSelectedItem = DashboardBottomBarItemType.EXPLORE
                    }
                ),
                DashboardBottomBarItem(
                    isSelected = currentSelectedItem == DashboardBottomBarItemType.CART,
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
                    onClick = {
                        currentSelectedItem = DashboardBottomBarItemType.CART
                    }
                ),
                DashboardBottomBarItem(
                    isSelected = currentSelectedItem == DashboardBottomBarItemType.FAVORITE,
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
                    onClick = {
                        currentSelectedItem = DashboardBottomBarItemType.FAVORITE
                    }
                ),
                DashboardBottomBarItem(
                    isSelected = currentSelectedItem == DashboardBottomBarItemType.ACCOUNT,
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
                    onClick = {
                        currentSelectedItem = DashboardBottomBarItemType.ACCOUNT
                    }
                ),
            )
        )
    }
}
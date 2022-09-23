package com.randev.online_groceries.screen.dashboard.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.screen.dashboard.filter.components.FilterItem
import com.randev.online_groceries.screen.dashboard.filter.components.FilterTitle
import com.randev.online_groceries.screen.dashboard.filter.components.FilterTopBar
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.theme.HintTextColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 23/09/22
 */

@Composable
fun FilterScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val categories = listOf("Eggs", "Noodles & Pasta", "Chips & Crips", "Fast Food")
    val brand = listOf("Individual Collection", "Cocola", "Ifad", "Kazi Farmas")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column {
            FilterTopBar {
                navHostController.popBackStack()
            }
            Surface(
                color = HintTextColor.copy(alpha = 0.2f),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        item {
                            FilterTitle(title = "Categories", modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                        }
                        items(categories.size){ index ->
                            FilterItem(title = categories[index])
                        }
                        item {
                            FilterTitle(title = "Brand", modifier = Modifier.padding(top = 40.dp, bottom = 5.dp))
                        }
                        items(brand.size){ index ->
                            FilterItem(title = brand[index])
                        }
                    }
                    PrimaryButton(text = "Apply Filter", onClick = { })
                }
            }
        }
    }

}

@Preview
@Composable
fun PreviewFilterScreen() {
    OnlineGroceriesTheme {
        val navHostController = rememberNavController()
        FilterScreen(navHostController = navHostController)
    }
}
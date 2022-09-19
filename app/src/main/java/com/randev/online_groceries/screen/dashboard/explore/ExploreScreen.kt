package com.randev.online_groceries.screen.dashboard.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.DummyDataExplore
import com.randev.online_groceries.screen.dashboard.explore.components.ProductSection
import com.randev.online_groceries.ui.components.textfield.TextFieldSearch
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun ExploreScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "Find Products",
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            TextFieldSearch(query = "Search store", onQueryChanged = {} )
            ProductSection(
                exploreList = DummyDataExplore.exploreList()
            )
        }
    }
}

@Preview
@Composable
fun PreviewExploreScreen() {
    OnlineGroceriesTheme {
        ExploreScreen()
    }
}
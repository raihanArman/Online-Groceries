package com.randev.online_groceries.screen.dashboard.explore.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.data.Category
import com.randev.online_groceries.data.DummyDataExplore
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductSection(
    modifier: Modifier = Modifier,
    exploreList: List<Category>
) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        items(exploreList.size){index ->
            ExploreItem(category = exploreList[index])
        }
    }
}

@Preview
@Composable
fun PreviewProductSection() {
    OnlineGroceriesTheme {
        ProductSection(
            exploreList = DummyDataExplore.exploreList()
        )
    }
}
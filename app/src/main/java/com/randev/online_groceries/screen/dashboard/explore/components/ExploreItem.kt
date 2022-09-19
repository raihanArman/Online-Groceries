package com.randev.online_groceries.screen.dashboard.explore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.data.Category
import com.randev.online_groceries.data.DummyDataCategory
import com.randev.online_groceries.data.DummyDataExplore
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    category: Category
) {
    Card(
        modifier = modifier
            .height(190.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, color = category.color),
        backgroundColor = category.color.copy(alpha = 0.2f),
        elevation = 0.dp,
        shape = RoundedCornerShape(18.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            contentAlignment = Alignment.Center,
        ){
            Column(
                modifier = Modifier
                    .width(120.dp)
            ){
                Image(
                    painter = painterResource(id = category.image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(110.dp)
                        .weight(1f)
                )
                Text(
                    text = category.name,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewExploreItem() {
    OnlineGroceriesTheme() {
        ExploreItem(category = DummyDataExplore.exploreList()[3])
    }
}
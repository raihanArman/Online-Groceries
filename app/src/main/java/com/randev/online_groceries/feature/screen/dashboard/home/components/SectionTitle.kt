package com.randev.online_groceries.feature.screen.dashboard.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 17/09/22
 */


@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    title: String,
    onClickSeeAll: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = title,
            fontSize = 24.sp,
            fontFamily = MaterialTheme.typography.h3.fontFamily,
            color = SecondaryColor
        )
        Text(
            modifier = Modifier
                .clickable {
                    onClickSeeAll()
                },
            text = "See all",
            fontFamily = MaterialTheme.typography.h3.fontFamily,
            fontSize = 16.sp,
            color = PrimaryColor
        )
    }
}

@Preview
@Composable
fun PreviewSectionTitle() {
    OnlineGroceriesTheme {
        SectionTitle(
            title = "Exclusive Offer",
            onClickSeeAll = {}
        )
    }
}
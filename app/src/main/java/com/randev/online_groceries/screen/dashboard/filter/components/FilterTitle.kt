package com.randev.online_groceries.screen.dashboard.filter.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 23/09/22
 */

@Composable
fun FilterTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontFamily = MaterialTheme.typography.h3.fontFamily,
        fontSize = 24.sp,
        color = SecondaryColor,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewFilterTitle() {
    OnlineGroceriesTheme() {
        FilterTitle(title = "Categories")
    }
}
package com.randev.online_groceries.ui.components.appbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Composable
fun MainTopBar(
    title: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = title,
                    fontFamily = MaterialTheme.typography.h4.fontFamily,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Divider(
                color = BorderColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainTopBar() {
    OnlineGroceriesTheme() {
        MainTopBar(title = "My Cart")
    }
}
package com.randev.online_groceries.screen.dashboard.filter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 23/09/22
 */

@Composable
fun FilterTopBar(
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
        Text(
            text = "Filter",
            fontFamily = MaterialTheme.typography.h4.fontFamily,
            fontSize = 20.sp,
            color = SecondaryColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(end = 40.dp)
        )
    }
}
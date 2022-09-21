package com.randev.online_groceries.ui.components.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun BadgeCustom(
    text: String,
    textSize: TextUnit
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = Color.Black.copy(alpha = 0.2f)
    ){
        Text(
            text = text,
            color = Color.White,
            fontFamily = MaterialTheme.typography.h3.fontFamily,
            fontSize = textSize,
            modifier = Modifier
                .padding(4.dp)
        )
    }
}
package com.randev.online_groceries.ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 14.sp,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
        color = TextGreyColor,
        textAlign = textAlign,
        fontSize = textSize
    )
}
package com.randev.online_groceries.ui.components.space

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun HorizontalSpace(
    width: Dp
) {
    Spacer(
        modifier = Modifier.width(width)
    )
}
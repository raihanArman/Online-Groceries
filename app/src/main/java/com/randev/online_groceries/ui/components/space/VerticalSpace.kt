package com.randev.online_groceries.ui.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Raihan Arman
 * @date 13/09/22
 */

@Composable
fun VerticalSpace(
    height: Dp
) {
    Spacer(
        modifier = Modifier
            .height(height)
    )
}
package com.randev.online_groceries.ui.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.R

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(24.dp),
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
            contentDescription = null
        )
    }
}
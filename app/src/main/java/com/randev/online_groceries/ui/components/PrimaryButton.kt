package com.randev.online_groceries.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 13/09/22
 */

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit
) { 
    Button(
        modifier = modifier
            .height(67.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = Shapes.large
    ) {
        Text(
            text = text,
        )
    }
}

@Preview
@Composable
fun PreviewPrimaryButton(){
    OnlineGroceriesTheme() {
        PrimaryButton(text = "Get Started") {
            
        }
    }
}
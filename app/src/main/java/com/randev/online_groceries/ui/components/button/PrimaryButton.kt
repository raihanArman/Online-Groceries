package com.randev.online_groceries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
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
    onClick: () -> Unit,
    badge: @Composable () -> Unit = {}
) { 
    Button(
        modifier = modifier
            .height(67.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = Shapes.large
    ) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = text,
                textAlign = TextAlign.Center
            )
            badge()
        }
    }
}

@Preview
@Composable
fun PreviewPrimaryButton(){
    OnlineGroceriesTheme() {
        PrimaryButton(
            text = "Get Started",
            onClick = {},
            badge = {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.Black.copy(alpha = 0.2f)
                ){
                    Text(
                        text = "\$12.96",
                        color = Color.White,
                        fontFamily = MaterialTheme.typography.h3.fontFamily,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        )
    }
}
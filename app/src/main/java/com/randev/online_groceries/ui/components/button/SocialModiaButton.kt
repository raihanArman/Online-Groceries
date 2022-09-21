package com.randev.online_groceries.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.theme.GoogleColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    textColor: Color = Color.White,
    imageResource: Int,
    backgroundColor: Color
) {
    Button(
        modifier = modifier
            .height(67.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor, contentColor = Color.White),
        shape = Shapes.large
    ){
        Row(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
        ){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = text,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PreviewSocialMediaButton() {
    OnlineGroceriesTheme() {
        SocialMediaButton(
            onClick = {},
            text = "Continue with Google",
            imageResource = R.drawable.ic_google,
            backgroundColor = GoogleColor
        )
    }
}

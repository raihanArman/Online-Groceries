package com.randev.online_groceries.feature.screen.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

/**
 * @author Raihan Arman
 * @date 13/09/22
 */

@Composable
fun OnBoardScreen() {
    Box(
        contentAlignment = Alignment.BottomCenter
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_onboard),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(49.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null
            )
            VerticalSpace(35.dp)
            Text(
                modifier = Modifier
                    .width(253.dp),
                text = stringResource(R.string.onboard_title),
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                color = Color.White,
                fontFamily = MaterialTheme.typography.h3.fontFamily
            )
            Text(
                text = stringResource(R.string.onboard_subtitle),
                fontSize = 16.sp,
                fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                color = MaterialTheme.colors.primaryVariant
            )
            VerticalSpace(40.dp)
            PrimaryButton(
                modifier = Modifier
                    .padding(bottom = 50.dp),
                text = stringResource(R.string.get_started),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewOnBoardScreen() {
    OnlineGroceriesTheme {
        OnBoardScreen()
    }
}
package com.randev.online_groceries.screen.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.components.PrimaryButton
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.SecondaryColor
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 22/09/22
 */

@Composable
fun OrderDialog(
    onDismiss: () -> Unit,
    onBackToHome: () -> Unit,
    onPleaseTryAgain: () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(18.dp),
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(602.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                ) {
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bag),
                            contentDescription = null,
                            modifier = Modifier
                                .size(222.dp)
                        )
                        VerticalSpace(height = 49.dp)
                        Text(
                            text = "Opps! Order Failed",
                            fontFamily = MaterialTheme.typography.h3.fontFamily,
                            fontSize = 28.sp,
                            color = SecondaryColor,
                            modifier = Modifier
                                .width(265.dp),
                            textAlign = TextAlign.Center
                        )
                        VerticalSpace(height = 20.dp)
                        Text(
                            text = "Something went tembly wrong.",
                            fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
                            fontSize = 16.sp,
                            color = TextGreyColor,
                            modifier = Modifier
                                .width(278.dp),
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        VerticalSpace(height = 60.dp)
                        PrimaryButton(text = "Please Try Again", onClick = onPleaseTryAgain)
                        TextButton(
                            onClick = onBackToHome,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Back to Home",
                                fontFamily = MaterialTheme.typography.h3.fontFamily,
                                fontSize = 18.sp,
                                color = SecondaryColor
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOrderDialog() {
    val navHostController = rememberNavController()
    OnlineGroceriesTheme() {
        OrderDialog(onDismiss = {}, onBackToHome = {}, onPleaseTryAgain = {})
    }
}
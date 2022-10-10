package com.randev.online_groceries.ui.components.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.Country
import com.randev.online_groceries.data.DummyDataCountry
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun TextFieldPhoneNumber(
    modifier: Modifier = Modifier,
    title: String ?= null,
    text: () -> String,
    country: Country,
    onTextChanged: (String) -> Unit,
    onFlagClick: (Country) -> Unit,
    backgroundColor: Color = Color.White,
    readOnly: Boolean = false
) {
    Column(
        modifier = modifier,
    ) {
        if(title != null) Text(
            text = title,
            fontFamily = MaterialTheme.typography.h3.fontFamily,
            fontSize = 14.sp,
            color = TextGreyColor
        )
        VerticalSpace(height = 10.dp)
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text(),
            onValueChange = onTextChanged,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                unfocusedIndicatorColor = BorderColor
            ),
            readOnly = readOnly,
            leadingIcon = {
                Box(
                    modifier = Modifier
                        .width(33.dp)
                        .height(23.dp)
                        .clickable {
                            onFlagClick(country)
                        },
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = country.flag),
                        contentScale = ContentScale.Fit,
                        contentDescription = null,
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            )
        )
    }
}

@Preview
@Composable
fun PreviewEditTextPhoneNumber() {
    OnlineGroceriesTheme {
        TextFieldPhoneNumber(
            text = { "Kevin" },
            onTextChanged = {},
            onFlagClick = {},
            country = DummyDataCountry.countryList()[0]
        )
    }
}
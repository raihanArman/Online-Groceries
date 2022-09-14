package com.randev.online_groceries.ui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.TextGreyColor

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    title: String ?= null,
    text: String,
    onTextChanged: (String) -> Unit,
    backgroundColor: Color = Color.White,
    unfocusIndicatorColor: Color = BorderColor,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = modifier
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
            value = text,
            onValueChange = onTextChanged,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                unfocusedIndicatorColor = unfocusIndicatorColor
            ),
            leadingIcon = leadingIcon,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType
            )
        )
    }
}

@Preview
@Composable
fun PreviewTextFieldCustom() {
    OnlineGroceriesTheme {
        TextFieldCustom(
            text = "",
            onTextChanged = {}
        )
    }
}
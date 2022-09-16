package com.randev.online_groceries.ui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.core.VerticalSpace
import com.randev.online_groceries.ui.theme.BorderColor
import com.randev.online_groceries.ui.theme.HintTextColor
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
    textHint: String ?= null,
    text: String,
    onTextChanged: (String) -> Unit,
    backgroundColor: Color = Color.White,
    unfocusIndicatorColor: Color = BorderColor,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextFieldProvider: () -> Boolean = { false },
) {
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
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
                .fillMaxWidth()
                .padding(0.dp),
            value = text,
            onValueChange = onTextChanged,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                unfocusedIndicatorColor = unfocusIndicatorColor
            ),
            leadingIcon = leadingIcon,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType
            ),
            trailingIcon = if(trailingIcon != null) trailingIcon else{
                {
                    if(isPasswordTextFieldProvider()) {
                        IconButton(
                            onClick = {
                                isPasswordVisible.value = !isPasswordVisible.value
                            }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                painter = painterResource(
                                    id = if (isPasswordVisible.value) {
                                        R.drawable.ic_show_password
                                    } else {
                                        R.drawable.ic_hide_password
                                    }
                                ),
                                contentDescription = null
                            )
                        }
                    }
                }
            } ,
            placeholder = {
                if(textHint != null){
                    Text(
                        text = textHint,
                        color = HintTextColor
                    )
                }
            },
            visualTransformation = if(isPasswordTextFieldProvider()){
                if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
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
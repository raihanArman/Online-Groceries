package com.randev.online_groceries.ui.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.randev.online_groceries.R
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.HintTextColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.Shapes
import com.randev.online_groceries.ui.theme.TextFieldGreyColor

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@Composable
fun TextFieldSearch(
    modifier: Modifier = Modifier,
    query: String,
    hintText: String? = null,
    onQueryChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = query,
        onValueChange = onQueryChanged,
        shape = Shapes.large,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = TextFieldGreyColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            if(hintText != null){
                Text(
                    text = hintText,
                    color = HintTextColor
                )
            }
        },
    )
}

@Preview
@Composable
fun PreviewTextFieldSearch() {
    OnlineGroceriesTheme() {
        TextFieldSearch(modifier = Modifier, query = "", onQueryChanged = {})
    }
}
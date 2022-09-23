package com.randev.online_groceries.screen.dashboard.filter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.ui.components.space.HorizontalSpace
import com.randev.online_groceries.ui.theme.GreyColor
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.PrimaryColor
import com.randev.online_groceries.ui.theme.SecondaryColor

/**
 * @author Raihan Arman
 * @date 23/09/22
 */

@Composable
fun FilterItem(
    modifier: Modifier = Modifier,
    title: String
) {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it },
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryColor,
                uncheckedColor = GreyColor,
            ),
            modifier = Modifier
                .size(24.dp)
        )
        HorizontalSpace(width = 12.dp)
        Text(
            text = title,
            fontFamily = MaterialTheme.typography.subtitle1.fontFamily,
            fontSize = 16.sp,
            color = if(checkedState){
                PrimaryColor
            }else{
                SecondaryColor
            },
        )
    }
}

@Preview
@Composable
fun PreviewFilterItem() {
    OnlineGroceriesTheme {
        FilterItem(
            title = "Egg"
        )
    }
}
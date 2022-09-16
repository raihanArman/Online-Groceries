package com.randev.online_groceries.feature.screen.auth.location

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.Country
import com.randev.online_groceries.ui.components.textfield.TextFieldCustom
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 16/09/22
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryPicker(
    sheetState: ModalBottomSheetState,
    backgroundContent: @Composable () -> Unit,
    onCountrySelected: (Country) -> Unit,
    countryList: List<Country>?,
    countrySearchQuery: String = "",
    onQueryUpdated: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    BackHandler(enabled = sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Column {
                    TextFieldCustom(
                        modifier = Modifier
                            .padding(16.dp),
                        text = countrySearchQuery,
                        onTextChanged = onQueryUpdated,
                        title = "Search country",
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                    )
                    val lazyListState = rememberLazyListState()
                    LazyColumn(
                        state = lazyListState,
                    ){
                        countryList?.let { countries ->
                            items(countries.size){ index ->
                                CountryItem(
                                    countryName = countries[index].name,
                                    countryCode = countries[index].code,
                                    onCountrySelected = {
                                        onCountrySelected(countries[index])
                                    }
                                )
                            }
                        }
                    }
                }
            }
        },
        sheetShape = RoundedCornerShape(0),
        sheetBackgroundColor = Color.White,
    ){
        backgroundContent()
    }
}

@Composable
private fun CountryItem(
    countryName: String,
    countryCode: String,
    onCountrySelected: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCountrySelected() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = countryName)
        Text(text = countryCode, modifier = Modifier.alpha(ContentAlpha.medium))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun PreviewCountryPicker() {
    OnlineGroceriesTheme() {
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val coroutineScope = rememberCoroutineScope()
        var currentQuery by remember { mutableStateOf("") }
        CountryPicker(sheetState = sheetState,
            backgroundContent = {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        coroutineScope.launch { sheetState.show() }
                    }) {
                    Text(text = "Test")
                }
            },
            onCountrySelected = {},
            countryList = listOf(
                Country(name = "India", code = "+91", flag = R.drawable.flag, id = 1)
            ).filter { it.name.contains(other = currentQuery, ignoreCase = true) },
            countrySearchQuery = currentQuery,
            onQueryUpdated = { updatedQuery -> currentQuery = updatedQuery })
    }
}
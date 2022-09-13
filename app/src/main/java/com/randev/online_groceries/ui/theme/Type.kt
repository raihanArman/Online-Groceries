package com.randev.online_groceries.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.randev.online_groceries.R

// Set of Material typography styles to start with

private val GiiroyExtraBold = FontFamily(
    Font(R.font.gilroy_extrabold)
)

private val GiiroySemiBold = FontFamily(
    Font(R.font.gilroy_semibold)
)

private val GiiroyBold = FontFamily(
    Font(R.font.gilroy_bold)
)

private val GiiroyMedium = FontFamily(
    Font(R.font.gilroy_medium)
)

private val GiiroyLight = FontFamily(
    Font(R.font.gilroy_medium)
)

private val GiiroyRegular = FontFamily(
    Font(R.font.gilroy_regular)
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = GiiroyExtraBold,
        fontSize = 40.sp,
    ),
    h2 = TextStyle(
        fontFamily = GiiroyExtraBold,
        fontSize = 36.sp
    ),
    h3 = TextStyle(
        fontFamily = GiiroySemiBold,
        fontSize = 13.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = GiiroyMedium,
        fontSize = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = GiiroyLight,
        fontSize = 13.sp
    ),
    button = TextStyle(
        fontFamily = GiiroySemiBold,
        fontSize = 18.sp
    ),
    caption = TextStyle(
        fontFamily = GiiroyRegular,
        fontSize = 12.sp
    )
)
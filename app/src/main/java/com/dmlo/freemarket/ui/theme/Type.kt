package com.dmlo.freemarket.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val cardTitleTypo: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        )
    }

val screenTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            letterSpacing = 0.15.sp
        )
    }

val priceTypo: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = 0.15.sp
        )
    }

val originalPriceTypo: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.15.sp,
            textDecoration = TextDecoration.LineThrough
        )
    }

val installmentTypo: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.15.sp
        )
    }

val tagTypo: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            letterSpacing = 0.15.sp,
            color = Color.White
        )
    }
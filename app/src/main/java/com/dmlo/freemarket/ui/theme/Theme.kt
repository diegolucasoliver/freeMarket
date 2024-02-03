package com.dmlo.freemarket.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DefaultColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Secondary
)

@Composable
fun DefaultTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DefaultColorPalette,
        typography = Typography,
        content = content
    )
}
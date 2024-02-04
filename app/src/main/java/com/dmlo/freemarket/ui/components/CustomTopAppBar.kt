package com.dmlo.freemarket.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.dmlo.freemarket.ui.theme.screenTitle

@Composable
fun CustomTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    AppBar(
        backgroundColor,
        contentColor,
        modifier
    ) {
        if (navigationIcon == null) {
            Spacer(Modifier.width(16.dp - 4.dp))
        } else {
            Row(
                Modifier
                    .fillMaxHeight()
                    .width(72.dp - 4.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                CompositionLocalProvider(
                    value = LocalContentColor provides MaterialTheme.colorScheme.onSurface,
                    content = navigationIcon
                )
            }
        }

        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProvideTextStyle(value = screenTitle) {
                CompositionLocalProvider(
                    value = LocalContentColor provides MaterialTheme.colorScheme.onSurface,
                    content = title
                )
            }
        }
    }
}

@Composable
private fun AppBar(
    backgroundColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        shape = RectangleShape,
        modifier = modifier
    ) {
        CompositionLocalProvider(
            value = LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}


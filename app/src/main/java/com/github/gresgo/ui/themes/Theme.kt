package com.github.gresgo.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val darkThemeColors = darkColors(
    primary = purple,
    primaryVariant = purpleDark,
    secondary = tealLight
)

private val lightThemeColors = lightColors(
    primary = purpleLight,
    primaryVariant = purple,
    secondary = tealLight
)

@Composable
fun MainTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkThemeColors
    } else {
        lightThemeColors
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}
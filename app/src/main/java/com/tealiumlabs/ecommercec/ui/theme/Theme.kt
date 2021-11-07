package com.tealiumlabs.ecommercec.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Yellow800,
    primaryVariant = Yellow800,
    secondary = secondary,
    surface = colorPrimaryDark,
    background = colorPrimaryDark,
    onPrimary = Color.White,
    onSecondary = colorDarkText,
    onBackground = colorDarkText,
    onSurface = colorDarkText,
)

private val LightColorPalette = lightColors(
    primary = Yellow800,
    //primary = Teal200,
    primaryVariant = Yellow800,
    //primaryVariant = Teal200,
    secondary = secondary,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = colorTextHeading,
    onBackground = colorTextHeading,
    onSurface = colorTextHeading,
)

@Composable
fun ECommerceCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    /*
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    */
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = EcommTypography,
        shapes = Shapes,
        content = content
    )
}
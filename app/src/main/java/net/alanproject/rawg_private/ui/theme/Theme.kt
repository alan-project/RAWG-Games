package net.alanproject.rawg_private.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple500,
    primaryVariant = Purple500,
    secondary = Teal200,
    background = Color.Black,
    surface = blackSurface,
    onPrimary = Yellow200,
    onSurface = Charcoal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple500,
    secondary = Teal200,
    background = Color.Black,
    surface = Charcoal500,
    onPrimary = Yellow200,
    onSurface = Charcoal200

    /* Other default colors to override
,

    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Rawg_privateTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    darkTheme: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
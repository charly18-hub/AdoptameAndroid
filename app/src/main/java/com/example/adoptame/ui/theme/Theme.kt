package com.example.adoptame.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = Primary,
    onPrimary = ButtonText,

    secondary = Secondary,
    onSecondary = ButtonText,

    background = Background,
    onBackground = TextPrimary,

    surface = Surface,
    onSurface = TextPrimary,

    error = Error

)

private val DarkColors = darkColorScheme(

    primary = PrimaryLight,
    onPrimary = ButtonText,

    secondary = SecondaryLight,
    onSecondary = ButtonText,

    background = TextPrimary,
    onBackground = Surface,

    surface = PrimaryDark,
    onSurface = Surface,

    error = Error

)

@Composable
fun AdoptameTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme =
            if (darkTheme)
                DarkColors
            else
                LightColors,

        typography = Typography,

        content = content

    )

}
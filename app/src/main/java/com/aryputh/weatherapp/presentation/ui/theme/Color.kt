package com.aryputh.weatherapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Dark theme colors
val DarkPrimary = Color(0xFFF5F5F5)
val DarkSecondary = Color(0xFFE0E0E0)
val DarkUpperBackground = Color(0xFF959BE5)
val DarkLowerBackground = Color(0xFF6B6FA3)
val DarkBackground = Brush.verticalGradient(
    colors = listOf(DarkUpperBackground, DarkLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)

// Light theme colors
val LightPrimary = Color(0xFFF5F5F5)
val LightSecondary = Color(0xFFE0E0E0)
val LightUpperBackground = Color(0xFF86BBFD)
val LightLowerBackground = Color(0xFF6F98CC)
val LightBackground = Brush.verticalGradient(
    colors = listOf(LightUpperBackground, LightLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)

// Icon colors
val Humidity = Color(0xFF8ECAE6)
val UVIndex = Color(0xFFE9C46A)
val Sunrise = Color(0xFFF4A261)
val Sunset = Color(0xFFE76F51)
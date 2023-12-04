package com.aryputh.weatherapp.presentation.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Dark theme colors
val DarkPrimary = Color(0xFFF0F0F0)
val DarkSecondary = Color(0xFFE0E0E0)
val DarkUpperBackground = Color(0xFF8385D5)
val DarkLowerBackground = Color(0xFF959BE5)
val DarkBackground = Brush.verticalGradient(
    colors = listOf(DarkUpperBackground, DarkLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)

// Light theme colors
val LightPrimary = Color(0xFFF0F0F0)
val LightSecondary = Color(0xFFE0E0E0)
val LightUpperBackground = Color(0xFF68A6B9)
val LightLowerBackground = Color(0xFF4FA7C2)
val LightBackground = Brush.verticalGradient(
    colors = listOf(LightUpperBackground, LightLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)

// Icon colors
val Humidity = Color(0xFFF0F0F0)
val UVIndex = Color(0xFFF0F0F0)
val Sunrise = Color(0xFFF0F0F0)
val Sunset = Color(0xFFF0F0F0)
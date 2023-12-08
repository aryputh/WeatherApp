package com.aryputh.weatherapp.presentation.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Common theme colors
val Primary = Color(0xFFFAF9F6)
val Secondary = Color(0xFFEDEADE)

// Icon colors
val Humidity = Color(0xFFFAF9F6)
val UVIndex = Color(0xFFFAF9F6)
val Sunrise = Color(0xFFFAF9F6)
val Sunset = Color(0xFFFAF9F6)

// Dark theme colors
val DarkUpperBackground = Color(0xFF8385D5)
val DarkLowerBackground = Color(0xFF959BE5)
val DarkBackground = Brush.verticalGradient(
    colors = listOf(DarkUpperBackground, DarkLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)

// Light theme colors
val LightUpperBackground = Color(0xFF68A6B9)
val LightLowerBackground = Color(0xFF4FA7C2)
val LightBackground = Brush.verticalGradient(
    colors = listOf(LightUpperBackground, LightLowerBackground),
    startY = 0F,
    endY = Float.POSITIVE_INFINITY
)
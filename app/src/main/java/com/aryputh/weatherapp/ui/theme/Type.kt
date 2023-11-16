package com.aryputh.weatherapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aryputh.weatherapp.R

val MyCustomFont = FontFamily(
    Font(R.font.roboto_mono_normal, FontWeight.Normal),
    Font(R.font.roboto_mono_medium, FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MyCustomFont,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(fontFamily = MyCustomFont),
    displayMedium = TextStyle(fontFamily = MyCustomFont),
    displaySmall = TextStyle(fontFamily = MyCustomFont),
    headlineLarge = TextStyle(fontFamily = MyCustomFont),
    headlineMedium = TextStyle(fontFamily = MyCustomFont),
    headlineSmall = TextStyle(fontFamily = MyCustomFont),
    titleLarge = TextStyle(fontFamily = MyCustomFont),
    titleMedium = TextStyle(fontFamily = MyCustomFont),
    titleSmall = TextStyle(fontFamily = MyCustomFont),
    bodyMedium = TextStyle(fontFamily = MyCustomFont),
    bodySmall = TextStyle(fontFamily = MyCustomFont),
    labelLarge = TextStyle(fontFamily = MyCustomFont),
    labelMedium = TextStyle(fontFamily = MyCustomFont),
    labelSmall = TextStyle(fontFamily = MyCustomFont)
)
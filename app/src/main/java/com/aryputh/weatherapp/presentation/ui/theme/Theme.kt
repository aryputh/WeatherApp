package com.aryputh.weatherapp.presentation.ui.theme

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView

@Composable
fun WeatherAppTheme(
    content: @Composable () -> Unit
){
    // If transparent nav and status bar are supported
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
    {
        val view = LocalView.current
        val window = (view.context as Activity).window

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    MaterialTheme(
        typography = Typography,
        content = content
    )
}
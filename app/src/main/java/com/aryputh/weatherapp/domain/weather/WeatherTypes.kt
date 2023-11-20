package com.aryputh.weatherapp

import androidx.annotation.DrawableRes

sealed class WeatherTypes (val weatherDesc: String, @DrawableRes val iconRes: Int){
    object Clear : WeatherTypes(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.day_clear
    )
    object Cloudy : WeatherTypes(
        weatherDesc = "Cloudy",
        iconRes = R.drawable.day_cloudy
    )
    object Fog : WeatherTypes(
        weatherDesc = "Foggy",
        iconRes = R.drawable.day_fog
    )
    object Drizzle : WeatherTypes(
        weatherDesc = "Drizzle",
        iconRes = R.drawable.day_drizzle
    )
    object FreezingDrizzle : WeatherTypes(
        weatherDesc = "Freezing Drizzle",
        iconRes = R.drawable.day_freezing_drizzle
    )
    object Rain : WeatherTypes(
        weatherDesc = "Rain",
        iconRes = R.drawable.day_rain
    )
    object Snow : WeatherTypes(
        weatherDesc = "Snow",
        iconRes = R.drawable.day_snow
    )
    object Thunderstorm : WeatherTypes(
        weatherDesc = "Thunderstorm",
        iconRes = R.drawable.day_thunderstorm
    )

    companion object {
        fun fromWMO(code: Int): WeatherTypes {
            return when (code) {
                0 -> Clear
                1,2,3 -> Cloudy
                45,48 -> Fog
                51,53,55 -> Drizzle
                56,57 -> FreezingDrizzle
                61,63,65,66,67,80,81,82 -> Rain
                71,73,75,77,85,86 -> Snow
                95,96,99 -> Thunderstorm
                else -> Clear
            }
        }
    }
}
package com.aryputh.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.aryputh.weatherapp.R

sealed class WeatherTypes (val weatherDesc: String, @DrawableRes val iconRes: Int){
    object DayClear : WeatherTypes(
        weatherDesc = "Clear Sky",
        iconRes = R.drawable.day_clear
    )
    object DayCloudy : WeatherTypes(
        weatherDesc = "Cloudy",
        iconRes = R.drawable.day_cloudy
    )
    object DayFog : WeatherTypes(
        weatherDesc = "Foggy",
        iconRes = R.drawable.day_fog
    )
    object DayDrizzle : WeatherTypes(
        weatherDesc = "Drizzle",
        iconRes = R.drawable.day_drizzle
    )
    object DayFreezingDrizzle : WeatherTypes(
        weatherDesc = "Freezing Drizzle",
        iconRes = R.drawable.day_freezing_drizzle
    )
    object DayRain : WeatherTypes(
        weatherDesc = "Rainy",
        iconRes = R.drawable.day_rain
    )
    object DaySnow : WeatherTypes(
        weatherDesc = "Snowy",
        iconRes = R.drawable.day_snow
    )
    object DayThunderstorm : WeatherTypes(
        weatherDesc = "Thunderstorm",
        iconRes = R.drawable.day_thunderstorm
    )

    object NightClear : WeatherTypes(
        weatherDesc = "Clear Sky",
        iconRes = R.drawable.night_clear
    )
    object NightCloudy : WeatherTypes(
        weatherDesc = "Cloudy",
        iconRes = R.drawable.night_cloudy
    )
    object NightFog : WeatherTypes(
        weatherDesc = "Foggy",
        iconRes = R.drawable.night_fog
    )
    object NightDrizzle : WeatherTypes(
        weatherDesc = "Drizzle",
        iconRes = R.drawable.night_drizzle
    )
    object NightFreezingDrizzle : WeatherTypes(
        weatherDesc = "Freezing Drizzle",
        iconRes = R.drawable.night_freezing_drizzle
    )
    object NightRain : WeatherTypes(
        weatherDesc = "Rainy",
        iconRes = R.drawable.night_rain
    )
    object NightSnow : WeatherTypes(
        weatherDesc = "Snowy",
        iconRes = R.drawable.night_snow
    )
    object NightThunderstorm : WeatherTypes(
        weatherDesc = "Thunderstorm",
        iconRes = R.drawable.night_thunderstorm
    )

    companion object {
        fun fromWMO(code: Int, isDay: Int): WeatherTypes {
            if (isDay == 1)
            {
                return when (code) {
                    0 -> DayClear
                    1,2,3 -> DayCloudy
                    45,48 -> DayFog
                    51,53,55 -> DayDrizzle
                    56,57 -> DayFreezingDrizzle
                    61,63,65,66,67,80,81,82 -> DayRain
                    71,73,75,77,85,86 -> DaySnow
                    95,96,99 -> DayThunderstorm
                    else -> DayClear
                }
            }
            else
            {
                return when (code) {
                    0 -> NightClear
                    1,2,3 -> NightCloudy
                    45,48 -> NightFog
                    51,53,55 -> NightDrizzle
                    56,57 -> NightFreezingDrizzle
                    61,63,65,66,67,80,81,82 -> NightRain
                    71,73,75,77,85,86 -> NightSnow
                    95,96,99 -> NightThunderstorm
                    else -> NightClear
                }
            }
        }
    }
}
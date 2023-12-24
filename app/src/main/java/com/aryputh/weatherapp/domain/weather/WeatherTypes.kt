package com.aryputh.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.aryputh.weatherapp.R

sealed class WeatherTypes (val weatherDesc: String, @DrawableRes val iconRes: Int){
    object DayClear : WeatherTypes(
        weatherDesc = "Clear Sky",
        iconRes = R.drawable.day_clear
    )
    object DayMainlyClear : WeatherTypes(
        weatherDesc = "Mainly Clear",
        iconRes = R.drawable.day_cloudy
    )
    object DayPartlyCloudy : WeatherTypes(
        weatherDesc = "Partly Cloudy",
        iconRes = R.drawable.day_cloudy
    )
    object DayOvercast : WeatherTypes(
        weatherDesc = "Overcast",
        iconRes = R.drawable.day_cloudy
    )
    object DayFog : WeatherTypes(
        weatherDesc = "Fog",
        iconRes = R.drawable.day_fog
    )
    object DayLightDrizzle : WeatherTypes(
        weatherDesc = "Light Drizzle",
        iconRes = R.drawable.day_drizzle
    )
    object DayModerateDrizzle : WeatherTypes(
        weatherDesc = "Moderate Drizzle",
        iconRes = R.drawable.day_drizzle
    )
    object DayHeavyDrizzle : WeatherTypes(
        weatherDesc = "Heavy Drizzle",
        iconRes = R.drawable.day_drizzle
    )
    object DayLightFreezingDrizzle : WeatherTypes(
        weatherDesc = "Light Freezing Drizzle",
        iconRes = R.drawable.day_freezing_drizzle
    )
    object DayHeavyFreezingDrizzle : WeatherTypes(
        weatherDesc = "Heavy Freezing Drizzle",
        iconRes = R.drawable.day_freezing_drizzle
    )
    object DayLightRain : WeatherTypes(
        weatherDesc = "Light Rain",
        iconRes = R.drawable.day_rain
    )
    object DayModerateRain : WeatherTypes(
        weatherDesc = "Moderate Rain",
        iconRes = R.drawable.day_rain
    )
    object DayHeavyRain : WeatherTypes(
        weatherDesc = "Heavy Rain",
        iconRes = R.drawable.day_rain
    )
    object DayLightFreezingRain : WeatherTypes(
        weatherDesc = "Light Freezing Rain",
        iconRes = R.drawable.day_rain
    )
    object DayHeavyFreezingRain : WeatherTypes(
        weatherDesc = "Heavy Freezing Rain",
        iconRes = R.drawable.day_rain
    )
    object DayLightRainShower : WeatherTypes(
        weatherDesc = "Light Rain Shower",
        iconRes = R.drawable.day_rain
    )
    object DayModerateRainShower : WeatherTypes(
        weatherDesc = "Moderate Rain Shower",
        iconRes = R.drawable.day_rain
    )
    object DayHeavyRainShower : WeatherTypes(
        weatherDesc = "Heavy Rain Shower",
        iconRes = R.drawable.day_rain
    )
    object DayLightSnow : WeatherTypes(
        weatherDesc = "Light Snow",
        iconRes = R.drawable.day_snow
    )
    object DayModerateSnow : WeatherTypes(
        weatherDesc = "Moderate Snow",
        iconRes = R.drawable.day_snow
    )
    object DayHeavySnow : WeatherTypes(
        weatherDesc = "Heavy Snow",
        iconRes = R.drawable.day_snow
    )
    object DaySnowGrain : WeatherTypes(
        weatherDesc = "Snow Grains",
        iconRes = R.drawable.day_snow
    )
    object DayLightSnowShower : WeatherTypes(
        weatherDesc = "Light Snow Shower",
        iconRes = R.drawable.day_snow
    )
    object DayHeavySnowShower : WeatherTypes(
        weatherDesc = "Heavy Snow Shower",
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
    object NightMainlyClear : WeatherTypes(
        weatherDesc = "Mainly Clear",
        iconRes = R.drawable.night_cloudy
    )
    object NightPartlyCloudy : WeatherTypes(
        weatherDesc = "Partly Cloudy",
        iconRes = R.drawable.night_cloudy
    )
    object NightOvercast : WeatherTypes(
        weatherDesc = "Overcast",
        iconRes = R.drawable.night_cloudy
    )
    object NightFog : WeatherTypes(
        weatherDesc = "Fog",
        iconRes = R.drawable.night_fog
    )
    object NightLightDrizzle : WeatherTypes(
        weatherDesc = "Light Drizzle",
        iconRes = R.drawable.night_drizzle
    )
    object NightModerateDrizzle : WeatherTypes(
        weatherDesc = "Moderate Drizzle",
        iconRes = R.drawable.night_drizzle
    )
    object NightHeavyDrizzle : WeatherTypes(
        weatherDesc = "Heavy Drizzle",
        iconRes = R.drawable.night_drizzle
    )
    object NightLightFreezingDrizzle : WeatherTypes(
        weatherDesc = "Light Freezing Drizzle",
        iconRes = R.drawable.night_freezing_drizzle
    )
    object NightHeavyFreezingDrizzle : WeatherTypes(
        weatherDesc = "Heavy Freezing Drizzle",
        iconRes = R.drawable.night_freezing_drizzle
    )
    object NightLightRain : WeatherTypes(
        weatherDesc = "Light Rain",
        iconRes = R.drawable.night_rain
    )
    object NightModerateRain : WeatherTypes(
        weatherDesc = "Moderate Rain",
        iconRes = R.drawable.night_rain
    )
    object NightHeavyRain : WeatherTypes(
        weatherDesc = "Heavy Rain",
        iconRes = R.drawable.night_rain
    )
    object NightLightFreezingRain : WeatherTypes(
        weatherDesc = "Light Freezing Rain",
        iconRes = R.drawable.night_rain
    )
    object NightHeavyFreezingRain : WeatherTypes(
        weatherDesc = "Heavy Freezing Rain",
        iconRes = R.drawable.night_rain
    )
    object NightLightRainShower : WeatherTypes(
        weatherDesc = "Light Rain Shower",
        iconRes = R.drawable.night_rain
    )
    object NightModerateRainShower : WeatherTypes(
        weatherDesc = "Moderate Rain Shower",
        iconRes = R.drawable.night_rain
    )
    object NightHeavyRainShower : WeatherTypes(
        weatherDesc = "Heavy Rain Shower",
        iconRes = R.drawable.night_rain
    )
    object NightLightSnow : WeatherTypes(
        weatherDesc = "Light Snow",
        iconRes = R.drawable.night_snow
    )
    object NightModerateSnow : WeatherTypes(
        weatherDesc = "Moderate Snow",
        iconRes = R.drawable.night_snow
    )
    object NightHeavySnow : WeatherTypes(
        weatherDesc = "Heavy Snow",
        iconRes = R.drawable.night_snow
    )
    object NightSnowGrain : WeatherTypes(
        weatherDesc = "Snow Grains",
        iconRes = R.drawable.night_snow
    )
    object NightLightSnowShower : WeatherTypes(
        weatherDesc = "Light Snow Shower",
        iconRes = R.drawable.night_snow
    )
    object NightHeavySnowShower : WeatherTypes(
        weatherDesc = "Heavy Snow Shower",
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
                    1 -> DayMainlyClear
                    2 -> DayPartlyCloudy
                    3 -> DayOvercast
                    45,48 -> DayFog
                    51 -> DayLightDrizzle
                    53 -> DayModerateDrizzle
                    55 -> DayHeavyDrizzle
                    56 -> DayLightFreezingDrizzle
                    57 -> DayHeavyFreezingDrizzle
                    61 -> DayLightRain
                    63 -> DayModerateRain
                    65 -> DayHeavyRain
                    66 -> DayLightFreezingRain
                    67 -> DayHeavyFreezingRain
                    80 -> DayLightRainShower
                    81 -> DayModerateRainShower
                    82 -> DayHeavyRainShower
                    71 -> DayLightSnow
                    73 -> DayModerateSnow
                    75 -> DayHeavySnow
                    77 -> DaySnowGrain
                    85 -> DayLightSnowShower
                    86 -> DayHeavySnowShower
                    95,96,99 -> DayThunderstorm
                    else -> DayClear
                }
            }
            else
            {
                return when (code) {
                    0 -> NightClear
                    1 -> NightMainlyClear
                    2 -> NightPartlyCloudy
                    3 -> NightOvercast
                    45,48 -> NightFog
                    51 -> NightLightDrizzle
                    53 -> NightModerateDrizzle
                    55 -> NightHeavyDrizzle
                    56 -> NightLightFreezingDrizzle
                    57 -> NightHeavyFreezingDrizzle
                    61 -> NightLightRain
                    63 -> NightModerateRain
                    65 -> NightHeavyRain
                    66 -> NightLightFreezingRain
                    67 -> NightHeavyFreezingRain
                    80 -> NightLightRainShower
                    81 -> NightModerateRainShower
                    82 -> NightHeavyRainShower
                    71 -> NightLightSnow
                    73 -> NightModerateSnow
                    75 -> NightHeavySnow
                    77 -> NightSnowGrain
                    85 -> NightLightSnowShower
                    86 -> NightHeavySnowShower
                    95,96,99 -> NightThunderstorm
                    else -> NightClear
                }
            }
        }
    }
}
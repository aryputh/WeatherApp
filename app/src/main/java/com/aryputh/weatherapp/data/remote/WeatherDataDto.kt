package com.aryputh.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperature: List<Double>,
    @field:Json(name = "relative_humidity_2m")
    val humidity: List<Int>,
    @field:Json(name = "is_day")
    val isDay: List<Double>,
    @field:Json(name = "weather_code")
    val weatherCode: List<Double>,
    @field:Json(name = "cloud_cover")
    val cloudCover: List<Double>,
    @field:Json(name = "sunrise")
    val sunrise: List<Double>,
    @field:Json(name = "sunset")
    val sunset: List<Double>
)

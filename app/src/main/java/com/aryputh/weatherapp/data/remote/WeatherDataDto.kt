package com.aryputh.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperature: List<Double>,
    @field:Json(name = "relative_humidity_2m")
    val humidity: List<Double>,
    @field:Json(name = "is_day")
    val isDay: List<Int>,
    @field:Json(name = "weather_code")
    val weatherCode: List<Int>,
    @field:Json(name = "cloud_cover")
    val cloudCover: List<Double>,
    @field:Json(name = "sunrise")
    val sunrise: List<String>,
    @field:Json(name = "sunset")
    val sunset: List<String>
)

package com.aryputh.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "current")
    val currentWeatherData: WeatherDataDto,
    @field:Json(name = "daily")
    val dailyWeatherData: WeatherDataDto
)

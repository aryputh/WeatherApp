package com.aryputh.weatherapp.data.remote

import com.squareup.moshi.Json

data class DailyWeatherDataDto(
    @field:Json(name = "sunrise")
    val sunrise: List<String>,
    @field:Json(name = "sunset")
    val sunset: List<String>
)
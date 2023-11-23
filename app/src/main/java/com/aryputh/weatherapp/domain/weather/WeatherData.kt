package com.aryputh.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData (
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val humidity: Double,
    val isDay: Int,
    val weatherCode: Int,
    val cloudCover: Double,
    val sunrise: String,
    val sunset: String,
    val weatherType: WeatherTypes
)
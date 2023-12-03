package com.aryputh.weatherapp.domain.weather

data class WeatherInfo(
    val currentWeatherData: WeatherData?,
    val dailyWeatherData: WeatherData?
)
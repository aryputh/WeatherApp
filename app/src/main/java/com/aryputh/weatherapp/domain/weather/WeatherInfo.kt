package com.aryputh.weatherapp.domain.weather

class WeatherInfo (
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
    val dailyWeatherData: WeatherData?
)
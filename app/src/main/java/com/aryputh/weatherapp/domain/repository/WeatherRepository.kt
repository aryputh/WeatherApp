package com.aryputh.weatherapp.domain.repository

import com.aryputh.weatherapp.Resource
import com.aryputh.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
package com.aryputh.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?current=temperature_2m,relative_humidity_2m,is_day,weather_code,cloud_cover&daily=sunrise,sunset")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto
}
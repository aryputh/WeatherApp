package com.aryputh.weatherapp.data.repository

import com.aryputh.weatherapp.Resource
import com.aryputh.weatherapp.data.mappers.toWeatherInfo
import com.aryputh.weatherapp.data.remote.WeatherApi
import com.aryputh.weatherapp.domain.repository.WeatherRepository
import com.aryputh.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImplementation @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
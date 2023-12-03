package com.aryputh.weatherapp.data.repository

import android.util.Log
import com.aryputh.weatherapp.Resource
import com.aryputh.weatherapp.data.mappers.toWeatherInfo
import com.aryputh.weatherapp.data.remote.WeatherApi
import com.aryputh.weatherapp.data.remote.WeatherDto
import com.aryputh.weatherapp.domain.repository.WeatherRepository
import com.aryputh.weatherapp.domain.weather.WeatherInfo
import com.squareup.moshi.Moshi
import javax.inject.Inject

class WeatherRepositoryImplementation @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {

            val response = api.getWeatherData(lat = lat, long = long)
            val jsonResponse = Moshi.Builder().build().adapter(WeatherDto::class.java).toJson(response)
            Log.d("API_RESPONSE", jsonResponse)

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
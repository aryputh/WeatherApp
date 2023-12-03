package com.aryputh.weatherapp.data.mappers

import android.util.Log
import com.aryputh.weatherapp.data.remote.DailyWeatherDataDto
import com.aryputh.weatherapp.data.remote.WeatherDataDto
import com.aryputh.weatherapp.data.remote.WeatherDto
import com.aryputh.weatherapp.domain.weather.WeatherData
import com.aryputh.weatherapp.domain.weather.WeatherInfo
import com.aryputh.weatherapp.domain.weather.WeatherTypes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun DailyWeatherDataDto.toWeatherData(): WeatherData {
    return WeatherData(
        time = LocalDateTime.now(),
        temperatureCelsius = 0.0,
        humidity = 0.0,
        isDay = 0,
        weatherCode = 0,
        cloudCover = 0.0,
        sunrise = sunrise.firstOrNull() ?: "NULL",
        sunset = sunset.firstOrNull() ?: "NULL",
        weatherType = WeatherTypes.Clear
    )
}

fun WeatherDataDto.toWeatherData(): WeatherData {
    return WeatherData(
        time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
        temperatureCelsius = temperature,
        humidity = humidity,
        isDay = isDay,
        weatherCode = weatherCode,
        cloudCover = cloudCover,
        sunrise = sunrise?.firstOrNull() ?: "NULL",
        sunset = sunset?.firstOrNull() ?: "NULL",
        weatherType = WeatherTypes.fromWMO(weatherCode)
    )
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val dailyWeatherDataMap = dailyWeatherData.toWeatherData()
    val currentWeatherDataMap = currentWeatherData.toWeatherData()

    val dailySunrise = dailyWeatherData.sunrise;
    val dailySunset = dailyWeatherData.sunset;

    return WeatherInfo(
        currentWeatherData = currentWeatherDataMap.copy(
            sunrise = dailySunrise?.firstOrNull() ?: "NULL",
            sunset = dailySunset?.firstOrNull() ?: "NULL"
        ),
        dailyWeatherData = dailyWeatherDataMap
    )
}
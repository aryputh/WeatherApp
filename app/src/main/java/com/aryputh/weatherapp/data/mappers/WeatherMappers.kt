package com.aryputh.weatherapp.data.mappers

import android.util.Log
import com.aryputh.weatherapp.data.remote.DailyWeatherDataDto
import com.aryputh.weatherapp.data.remote.WeatherDataDto
import com.aryputh.weatherapp.data.remote.WeatherDto
import com.aryputh.weatherapp.domain.weather.WeatherData
import com.aryputh.weatherapp.domain.weather.WeatherInfo
import com.aryputh.weatherapp.domain.weather.WeatherTypes
import java.time.LocalDateTime
import java.time.ZoneId
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
        weatherType = WeatherTypes.DayClear
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
        weatherType = WeatherTypes.fromWMO(weatherCode, isDay)
    )
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val dailyWeatherDataMap = dailyWeatherData.toWeatherData()
    val currentWeatherDataMap = currentWeatherData.toWeatherData()

    val dailySunrise = dailyWeatherData.sunrise
    val dailySunset = dailyWeatherData.sunset

    val formattedSunrise = parseAndFormatDateTime(dailySunrise?.firstOrNull() ?: "NULL")
    val formattedSunset = parseAndFormatDateTime(dailySunset?.firstOrNull() ?: "NULL")

    return WeatherInfo(
        currentWeatherData = currentWeatherDataMap.copy(
            sunrise = formattedSunrise,
            sunset = formattedSunset
        ),
        dailyWeatherData = dailyWeatherDataMap
    )
}

fun parseAndFormatDateTime(dateTimeString: String?): String {
    return try {
        val parsedDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME)

        val formattedTime = DateTimeFormatter.ofPattern("h:mm a").format(parsedDateTime.toLocalTime())

        formattedTime
    } catch (e: Exception) {
        "NULL"
    }
}
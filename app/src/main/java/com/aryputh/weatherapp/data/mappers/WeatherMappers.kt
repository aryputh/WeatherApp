package com.aryputh.weatherapp.data.mappers

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

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperature[index]
        val humidity = humidity[index]
        val isDay = isDay[index]
        val weatherCode = weatherCode[index]
        val cloudCover = cloudCover[index]
        val sunrise = sunrise[index]
        val sunset = sunset[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                humidity = humidity,
                isDay = isDay,
                weatherCode = weatherCode,
                cloudCover = cloudCover,
                sunrise = sunrise,
                sunset = sunset,
                weatherType = WeatherTypes.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val currentWeatherDataMap = currentWeatherData.toWeatherDataMap()
    val dailyWeatherDataMap = dailyWeatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = currentWeatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    val dailyWeatherData = dailyWeatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = currentWeatherDataMap,
        currentWeatherData = currentWeatherData,
        dailyWeatherData = dailyWeatherData
    )
}
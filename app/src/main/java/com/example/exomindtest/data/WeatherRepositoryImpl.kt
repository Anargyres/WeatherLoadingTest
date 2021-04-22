package com.example.exomindtest.data

import com.example.exomindtest.domain.WeatherData

class WeatherRepositoryImpl(
    private val remoteWeather: RemoteWeather
) : WeatherRepository {
    override suspend fun getWeatherData(city_name: String): WeatherData {
        return remoteWeather.getWeatherData(city_name)
    }
}
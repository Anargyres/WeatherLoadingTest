package com.example.exomindtest.data

import com.example.exomindtest.domain.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(city_name: String): WeatherData
}
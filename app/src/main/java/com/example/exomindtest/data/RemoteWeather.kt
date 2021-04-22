package com.example.exomindtest.data

import com.example.exomindtest.domain.WeatherData

class RemoteWeather(private val weatherService: WeatherService) {
    /**
     * weather?q={city_name}&appid=370fa1f9be582ca85849ffcf1d110c76
     */
    suspend fun getWeatherData(city_name: String): WeatherData {
        val response = weatherService.getWeatherData(city_name)

        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: WeatherData.ERROR
            else -> WeatherData.ERROR
        }
    }
}
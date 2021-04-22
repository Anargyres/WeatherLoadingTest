package com.example.exomindtest.domain

import com.example.exomindtest.data.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun invoke(city_name: String): WeatherData {
        return weatherRepository.getWeatherData(city_name)
    }
}
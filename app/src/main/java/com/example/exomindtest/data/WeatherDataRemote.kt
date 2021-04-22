package com.example.exomindtest.data

import com.example.exomindtest.domain.Main
import com.example.exomindtest.domain.Weather
import com.example.exomindtest.domain.WeatherData

class WeatherDataRemote(
    val weather: Weather,
    val main: Main,
    val name: String
) {
    fun toEntity(): WeatherData {
        return WeatherData(
            weather = weather,
            main = main,
            name = name
        )
    }
}
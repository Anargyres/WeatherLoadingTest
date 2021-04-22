package com.example.exomindtest.domain

data class WeatherData(
    val weather: Weather,
    val main: Main,
    val name: String
) {
    companion object {
        val ERROR =
            WeatherData(Weather("", "", "", ""), Main(0F, 0, 0, 0F, 0F), "")
    }
}

data class Weather(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Float,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Float,
    val temp_max: Float
)
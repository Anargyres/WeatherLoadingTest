package com.example.exomindtest.domain

data class WeatherData(
    val weather: Weather,
    val main: Main,
    val name: String
) {
    companion object {
        val ERROR =
            WeatherData(Weather("", "", "", ""), Main(0.0, 0, 0, 0.0, 0.0), "")
    }
}

data class Weather(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Double,
    val temp_max: Double
)
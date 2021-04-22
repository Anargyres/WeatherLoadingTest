package com.example.exomindtest.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("weather?q={city_name}&appid=370fa1f9be582ca85849ffcf1d110c76")
    suspend fun getWeatherData(@Path("city_name") city_name: String): Response<WeatherDataRemote>
}
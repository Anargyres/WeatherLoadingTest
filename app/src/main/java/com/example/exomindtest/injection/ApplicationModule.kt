package com.example.exomindtest.injection

import com.example.exomindtest.data.RemoteWeather
import com.example.exomindtest.data.WeatherRepository
import com.example.exomindtest.data.WeatherRepositoryImpl
import com.example.exomindtest.data.WeatherService
import com.example.exomindtest.domain.GetWeatherUseCase
import com.example.exomindtest.presentation.viewmodel.LoadingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    single { RemoteWeather(get()) }

    single<WeatherService> { createWebService("api.openweathermap.org/data/2.5/") }
}

val presentationModule = module {

    viewModel { LoadingViewModel(get()) }
}

val domainModule = module {

    single { GetWeatherUseCase(get()) }
}

inline fun <reified T> createWebService(url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}
package com.example.exomindtest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exomindtest.domain.GetWeatherUseCase
import com.example.exomindtest.domain.WeatherData
import kotlinx.coroutines.launch

class LoadingViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _liveDataWeather: MutableLiveData<WeatherData> = MutableLiveData()
    val liveDataWeather: LiveData<WeatherData> get() = _liveDataWeather

    init {
        viewModelScope.launch {
            val jsonResult = getWeatherUseCase.invoke("Rennes")
        }
    }
}
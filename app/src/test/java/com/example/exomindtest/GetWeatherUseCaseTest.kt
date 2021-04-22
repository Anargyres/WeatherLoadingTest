package com.example.exomindtest

import com.example.exomindtest.data.WeatherRepository
import com.example.exomindtest.domain.GetWeatherUseCase
import com.example.exomindtest.domain.Main
import com.example.exomindtest.domain.Weather
import com.example.exomindtest.domain.WeatherData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetWeatherUseCaseTest {

    private val weatherRepository: WeatherRepository = mockk()

    private val classUnderTest = GetWeatherUseCase(weatherRepository)

    @Test
    fun `Get Weather Data`() {
        runBlocking {
            //GIVEN
            val expectedResult = WeatherData(
                weather = Weather("0", "Nuageux", "Beaucoup de nuages", "09D"),
                main = Main(12.3, 1013, 81, 8.1, 15.6),
                name = "Rennes"
            )

            coEvery { weatherRepository.getWeatherData("Rennes") } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke("Rennes")

            //THEN
            assertEquals(expectedResult, result)

        }
    }
}
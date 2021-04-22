package com.example.exomindtest.presentation.view

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.exomindtest.R
import com.example.exomindtest.presentation.viewmodel.LoadingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoadingActivity : AppCompatActivity() {

    private var progressBar: ProgressBar = findViewById(R.id.progressBar)
    private val loadingViewModel: LoadingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
    }

    override fun onStart() {
        super.onStart()
        initOberver()
    }

    private fun initOberver() {
        progressBar.max = 60
        val currentProgress = 10

        ObjectAnimator.ofInt(progressBar, "progress", currentProgress).setDuration(60000).start()
        when(progressBar.progress){
            0 -> loadingViewModel.getWeather("Rennes")
            10 -> loadingViewModel.getWeather("Paris")
            20 -> loadingViewModel.getWeather("Nantes")
            30 -> loadingViewModel.getWeather("Bordeaux")
            40 -> loadingViewModel.getWeather("Lyon")
        }
    }
}
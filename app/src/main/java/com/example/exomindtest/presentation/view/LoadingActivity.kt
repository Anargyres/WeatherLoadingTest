package com.example.exomindtest.presentation.view

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.exomindtest.R
import com.example.exomindtest.presentation.viewmodel.LoadingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoadingActivity : AppCompatActivity() {

    companion object {
        const val timer_max = 60
        const val current_progress = 10
    }

    private var progressBar: ProgressBar = findViewById(R.id.progressBar)
    private var progressText: TextView = findViewById(R.id.loading_text)
    private var retryButton: Button = findViewById(R.id.retry_button)

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
        launchProgressBar()

        retryButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            retryButton.visibility = View.GONE
            launchProgressBar()
        }
    }

    private fun launchProgressBar() {
        progressBar.max = timer_max

        ObjectAnimator.ofInt(progressBar, "progress", current_progress).setDuration(60000).start()
        when (progressBar.progress) {
            /**
             * J'ai mis le changement de texte toutes les 6 secondes dans ce when car je savais pas comment faire autrement
             */
            0 -> {
                loadingViewModel.getWeather("Rennes")
            }
            6 -> {
                progressText.text = getText(R.string.loading_text_2)
            }
            10 -> {
                loadingViewModel.getWeather("Paris")
            }
            12 -> {
                progressText.text = getText(R.string.loading_text_3)
            }
            18 -> {
                progressText.text = getText(R.string.loading_text_1)
            }
            20 -> {
                loadingViewModel.getWeather("Nantes")
            }
            24 -> {
                progressText.text = getText(R.string.loading_text_2)
            }
            30 -> {
                loadingViewModel.getWeather("Bordeaux")
                progressText.text = getText(R.string.loading_text_3)
            }
            36 -> {
                progressText.text = getText(R.string.loading_text_1)
            }
            40 -> {
                loadingViewModel.getWeather("Lyon")
            }
            42 -> {
                progressText.text = getText(R.string.loading_text_2)
            }
            48 -> {
                progressText.text = getText(R.string.loading_text_3)
            }
            54 -> {
                progressText.text = getText(R.string.loading_text_1)
            }
            60 -> {
                progressText.text = getText(R.string.loading_text_2)
            }
        }

        if (progressBar.progress == timer_max) {
            progressBar.visibility = View.GONE
            retryButton.visibility = View.VISIBLE
        }
    }
}
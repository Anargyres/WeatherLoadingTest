package com.example.exomindtest.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.exomindtest.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }

    private fun initObserver() {
        mainButton = findViewById(R.id.button_main)
        mainButton.setOnClickListener {
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.exomindtest.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.exomindtest.R

class MainActivity : AppCompatActivity() {

    private var mainButton: Button = findViewById(R.id.button_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }

    private fun initObserver() {
        mainButton.setOnClickListener {
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
        }
    }
}
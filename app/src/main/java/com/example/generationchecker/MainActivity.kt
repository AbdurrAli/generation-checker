package com.example.generationchecker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var inputTahun = findViewById<EditText>(R.id.birth_year)
        var buttonChecker = findViewById<Button>(R.id.btn_primary)
        var resultCheck = findViewById<TextView>(R.id.result_generation)


        buttonChecker.setOnClickListener {
            val input = inputTahun.text.toString()
            val hasil = when (input.toInt()) {
                in 1945..1964 -> "Baby Boomers"
                in 1965..1980 -> "Gen X"
                in 1981..1995 -> "Gen Milenial"
                in 1996..2010 -> "Gen Z"
                else -> "Gen Alpha"
            }
            resultCheck.text = "Kamu termasuk generasi $hasil"
        }
    }
}
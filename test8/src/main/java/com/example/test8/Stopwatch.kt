package com.example.test8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test8.databinding.ActivityMainBinding

class Stopwatch : AppCompatActivity() {

    var Start = 0L
    var Stop = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val btnstart = findViewById<Button>(R.id.btnstart)
        val btnstop = findViewById<Button>(R.id.btnstop)
        val btnReset = findViewById<Button>(R.id.btnreset)*/


    }


}
package com.example.test11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test11.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
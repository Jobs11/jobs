package com.example.chapter6

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.img1.visibility = View.INVISIBLE
        }

        /*val button1 = findViewById<Button>(R.id.btn1)
        val img1 = findViewById<ImageView>(R.id.img1)
        var status = 0

        button1.setOnClickListener {
            if (status == 0) {
                img1.visibility = View.INVISIBLE
                status = 1
            } else {
                img1.visibility = View.VISIBLE
                status = 0
            }
        }*/
    }
}
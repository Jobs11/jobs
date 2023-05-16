package com.example.test9

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowMetrics
import androidx.appcompat.app.AppCompatActivity
import com.example.test9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.tV1.text = getString(R.string.test)*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            binding.tV1.text = "width : ${windowMetrics.bounds.width()}, height : ${windowMetrics.bounds.height()}"
        } else {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            binding.tV1.text = "width : ${displayMetrics.widthPixels}, height : ${displayMetrics.heightPixels}"
        }
    }
}
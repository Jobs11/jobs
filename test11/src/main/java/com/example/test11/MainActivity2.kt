package com.example.test11

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this@MainActivity2, "업버튼 클릭시 동작", Toast.LENGTH_SHORT).show()
        return super.onSupportNavigateUp()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
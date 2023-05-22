package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this@LoginActivity, "업버튼 클릭시 동작", Toast.LENGTH_SHORT).show()
        return super.onSupportNavigateUp()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loghome.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.
        }

        binding.logreg.setOnClickListener {
            val intent = Intent(this@LoginActivity, MemberActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.
        }
    }
}
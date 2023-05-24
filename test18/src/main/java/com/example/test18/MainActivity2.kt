package com.example.test18

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.test18.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Glide.with(this).load(R.drawable.lavar).into(binding.resultView)

        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            Glide.with(this).load(it.data?.data).override(200, 200)
                .into(binding.resultView)
        }

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        requestLauncher.launch(intent)
    }
}
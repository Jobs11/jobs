package com.example.test11

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuItem1: MenuItem? = menu?.add(0, 0, 0, "menu1")
        val menuItem2: MenuItem? = menu?.add(0, 1, 0, "menu2")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        0 -> {
            Toast.makeText(this@MainActivity, "0번 메뉴", Toast.LENGTH_SHORT).show()
            true
        }

        1 -> {
            val intent = Intent(this@MainActivity, MainActivity3::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "1번 메뉴로~!", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /*override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this@MainActivity, "뒤로가기", Toast.LENGTH_SHORT).show()
        onBackPressed()
        return super.onSupportNavigateUp()
    }*/
}
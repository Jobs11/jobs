package com.example.test11

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.test11.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.Txt1.lineHeight

        binding.TxtA1.lineHeight
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_three, menu)
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("SEEE", "검색어 변경 ${newText}")
                return true
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity3, "클릭이벤트", Toast.LENGTH_SHORT).show()
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                return true
            }
        })
        return true
    }
}
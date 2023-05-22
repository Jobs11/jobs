package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            var title = it.title
            if (title.contentEquals("로그인")){
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.

            }else if (title.contentEquals("회원가입")){
                val intent = Intent(this@MainActivity, MemberActivity::class.java)
                startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.

            }else if (title.contentEquals("메인 화면")){
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.

            }else if (title.contentEquals("프로필 변경")){
            val intent = Intent(this@MainActivity, PictureActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.

            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 toggle 버튼에서 제공된거라면..
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
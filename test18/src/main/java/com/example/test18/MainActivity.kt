package com.example.test18

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test18.databinding.ActivityMainBinding
import com.example.test18.model.UserListModel
import com.example.test18.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.doGetUserList("2")



        binding.btntest.setOnClickListener {
            val test1 = networkService.test1()
            test1.enqueue(object: Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val userModelEX = response.body()
                    Log.d("SEEE", "EEEEE ${userModelEX}")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    call.cancel()
                }
            })
        }

        userListCall.enqueue(
            object: Callback<UserListModel> {
                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {
                    val userList = response.body()
                    Log.d("SEEE","EEEE ${userList}")
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    call.cancel()
                }

            })
    }
}
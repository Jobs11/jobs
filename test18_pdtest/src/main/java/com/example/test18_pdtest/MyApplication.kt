package com.example.test18_pdtest

import android.app.Application
import com.example.test18_pdtest.retrofit.INetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application(){
    companion object{
        val serviceKey ="LzDx7%2Bk8yaJc5%2BACVd1%2BoOThG2TNhRbGbLvLy2iSXEaDrLDQ7HuPHniqQvlc%2FL%2FL7z675HvMCc254wRZ241sJw%3D%3D"


        var networkService: INetworkService

        // 공공 데이터 주소
        // http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=인증키&numOfRows=10&pageNo=1
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/6260000/FoodService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(INetworkService::class.java)
        }
    }
}
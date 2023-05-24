package com.example.test18_pdtest.retrofit

import com.example.test18_pdtest.model.UserListModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface INetworkService {
    @GET("getFoodKr")
    // baseurl : https://reqres.in/
    //https://reqres.in/api/users?page=2
    fun doGetUserList(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String): Call<UserListModel>
    @GET
    fun getAvatarImage(@Url url: String): Call<ResponseBody>


}
package com.example.test18.retrofit

import com.example.test18.model.UserListModel
import com.example.test18.model.UserModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface INetworkService {
    @GET("api/users")
    // baseurl : https://reqres.in/
    //https://reqres.in/api/users?page=2
    fun doGetUserList(@Query("page") page: String): Call<UserListModel>
    @GET
    fun getAvatarImage(@Url url: String): Call<ResponseBody>

    @GET("users/2")
    fun test1(): Call<UserModel>

    @GET("group/{id}/users/{name}")
    fun test2(
        @Path("id") userId: String,
        @Path("name") arg2: String
    ): Call<UserModel>

    @GET("group/users")
    fun test3(
        @Query("sort") arg1: String,
        @Query("name") arg2: String
    ): Call<UserModel>

    @GET("group/users")
    fun test4(
        @QueryMap options: Map<String, String>,
        @Query("name") name: String
    ): Call<UserModel>

    @POST("group/users")
    fun test5(
        @Body user: UserModel,
        @Query("name") name: String
    ): Call<UserModel>

    @FormUrlEncoded
    @POST("user/edit")
    fun test6(
        @Field("first_name") first: String?,
        @Field("last_name") last: String?,
        @Query("name") name: String?
    ): Call<UserModel>

    @FormUrlEncoded
    @POST("tasks")
    fun test7(@Field("title") titles: List<String>): Call<UserModel>

    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    fun test8(): Call<UserModel>

    @GET
    fun test9(@Url url: String, @Query("name") name: String): Call<UserModel>
}
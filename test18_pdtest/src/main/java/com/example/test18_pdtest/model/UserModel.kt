package com.example.test18_pdtest.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class UserModel(
    // http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=인증키&numOfRows=10&pageNo=1
    var id: String,
    @SerializedName("first_name")
    var firstName: String,
    // @SerializedName("last_name")
    var lastName: String,
    var avatar: String,
    var email: String,
    var avatarBitmap: Bitmap

)
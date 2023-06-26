package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

data class ResponseUser(
    @SerializedName("message") val stt:String,
    val data:ArrayList<User>
)
package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

class ResponseCreate (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("user") var user:User,
    @SerializedName("token") var token:String,
)
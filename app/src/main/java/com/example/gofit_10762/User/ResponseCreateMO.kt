package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

class ResponseCreateMO (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:Pegawai,
)
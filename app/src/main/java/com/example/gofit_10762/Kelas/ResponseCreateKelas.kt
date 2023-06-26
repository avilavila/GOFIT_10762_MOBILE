package com.example.gofit_10762.Kelas

import com.google.gson.annotations.SerializedName

class ResponseCreateKelas (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<Kelas>,
)
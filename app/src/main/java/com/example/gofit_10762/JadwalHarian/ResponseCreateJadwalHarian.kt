package com.example.gofit_10762.JadwalHarian

import com.example.gofit_10762.Kelas.Kelas
import com.google.gson.annotations.SerializedName

class ResponseCreateJadwalHarian (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<JadwalHarian>,
)
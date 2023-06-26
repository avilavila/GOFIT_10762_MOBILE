package com.example.gofit_10762.User

import com.example.gofit_10762.IzinInstruktur.IzinInstruktur
import com.google.gson.annotations.SerializedName

class ResponseCreatePegawai (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<IzinInstruktur>,
)
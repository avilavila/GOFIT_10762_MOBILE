package com.example.gofit_10762.IzinInstruktur

import com.google.gson.annotations.SerializedName

class ResponseCreateInstruktur (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:Instruktur,
)
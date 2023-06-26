package com.example.gofit_10762.PresensiInstruktur

import com.google.gson.annotations.SerializedName

class ResponseHistoriInstruktur (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<HistoriInstruktur>,
)
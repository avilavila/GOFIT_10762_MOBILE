package com.example.gofit_10762.BookingKelas

import com.google.gson.annotations.SerializedName

class ResponseCreateBookingKelas (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<BookingKelas>,
)
package com.example.gofit_10762.BookingGym

import com.google.gson.annotations.SerializedName

class ResponseCreateBookingGym (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<BookingGym>,
)
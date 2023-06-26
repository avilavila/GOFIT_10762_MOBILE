package com.example.gofit_10762.BookingGym

import com.example.gofit_10762.IzinInstruktur.apiServiceIzinInstruktur
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RClientBookingGym {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://backend10762.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(apiServiceBookingGym::class.java)
}
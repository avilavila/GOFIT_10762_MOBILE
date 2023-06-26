package com.example.gofit_10762.BookingKelas

import com.example.gofit_10762.BookingGym.apiServiceBookingGym
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RClientBookingKelas {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://backend10762.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(apiServiceBookingKelas::class.java)
}
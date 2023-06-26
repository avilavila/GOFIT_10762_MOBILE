package com.example.gofit_10762.IzinInstruktur

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RClientIzinInstruktur {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://backend10762.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(apiServiceIzinInstruktur::class.java)
}
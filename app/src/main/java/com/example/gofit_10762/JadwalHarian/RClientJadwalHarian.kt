package com.example.gofit_10762.JadwalHarian

import com.example.gofit_10762.Kelas.apiServiceKelas
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RClientJadwalHarian {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://backend10762.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(apiServiceJadwalHarian::class.java)
}